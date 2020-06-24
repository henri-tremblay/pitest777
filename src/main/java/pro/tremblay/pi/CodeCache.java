package pro.tremblay.pi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CodeCache {
    private final ReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private final Map<String, List<Code>> map = new HashMap<>();

    public Code findById(String id) {
        Lock readLock = cacheLock.readLock();
        readLock.lock();
        try {
            for(String key: map.keySet()) {
                for(Code script: map.get(key)) {
                    if(script.getId().equals(id)) {
                        return script;
                    }
                }
            }
            return null;
        }
        finally {
            readLock.unlock();
        }
    }

}
