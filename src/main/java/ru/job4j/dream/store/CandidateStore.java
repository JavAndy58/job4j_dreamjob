package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CandidateStore {

    private static final CandidateStore INST = new CandidateStore();
    private AtomicInteger indexPost = new AtomicInteger(2);
    private Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Junior Java", "good", LocalDate.now()));
        candidates.put(2, new Candidate(2, "Middle Java", "good", LocalDate.now()));
    }

    public static CandidateStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public void create(Candidate candidate) {
        indexPost.getAndIncrement();
        candidates.put(indexPost.intValue(), new Candidate(indexPost.intValue(), candidate.getName(), candidate.getDesc(), LocalDate.now()));
    }

    public void update(Candidate candidate) {
        candidates.put(candidate.getId(), new Candidate(candidate.getId(), candidate.getName(), candidate.getDesc(), LocalDate.now()));
    }

    public Candidate findById(int id) {
        Candidate returnCandidate = null;
        Collection<Candidate> candidatesList = findAll();
        for (Candidate candidate : candidatesList) {
            if (candidate.getId() == id) {
                returnCandidate = candidate;
            }
        }
        return returnCandidate;
    }
}
