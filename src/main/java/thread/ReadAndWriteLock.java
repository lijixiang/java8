package thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁优化缓存系统
 */
public class ReadAndWriteLock {

    private Map<String, Object> cache = new HashMap<>();

    public Object getValue(String key) {
        ReadWriteLock rwl = new ReentrantReadWriteLock();
        rwl.readLock().lock();
        Object v = null;
        try {
            v = cache.get(key);
            if (v == null) {
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try{
                    if (v == null) {
                        v = "value"; // 查询数据库获取值
                        cache.put(key, v);
                    }
                }finally {
                    rwl.writeLock().unlock();
                }
                rwl.readLock().lock();
            }

        } finally {
            rwl.readLock().unlock();
        }
        return v;
    }
}
