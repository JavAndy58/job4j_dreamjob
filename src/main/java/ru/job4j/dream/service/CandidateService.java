package ru.job4j.dream.service;

import org.springframework.stereotype.Service;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.CandidateStore;
import java.util.Collection;

@Service
public class CandidateService {

    private final CandidateStore candidateStore;

    public CandidateService(CandidateStore candidateStore) {
        this.candidateStore = candidateStore;
    }

    public Collection<Candidate> findAll() {
        return candidateStore.findAll();
    }

    public void create(Candidate candidate) {
        candidateStore.create(candidate);
    }

    public void update(Candidate candidate) {
        candidateStore.update(candidate);
    }

    public Candidate findById(int id) {
        return candidateStore.findById(id);
    }
}
