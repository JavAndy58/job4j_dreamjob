package ru.job4j.dream.store;

import org.springframework.stereotype.Repository;
import ru.job4j.dream.model.Candidate;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class CandidateStore {

    private AtomicInteger ids = new AtomicInteger(2);
    private Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Junior Java", "good", LocalDate.now(), null));
        candidates.put(2, new Candidate(2, "Middle Java", "good", LocalDate.now(), null));
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public void create(Candidate candidate) {
        candidate.setId(ids.incrementAndGet());
        candidates.put(candidate.getId(), candidate);
    }

    public void update(Candidate candidate) {
        candidates.put(candidate.getId(), new Candidate(candidate.getId(),
                candidate.getName(), candidate.getDesc(), LocalDate.now(), null));
    }

    public Candidate findById(int id) {
        return candidates.get(id);
    }
}
