package ru.job4j.dreamjob.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Candidate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public final class MemoryCandidateRepository implements CandidateRepository {

    private AtomicInteger nextId = new AtomicInteger(1);

    private final ConcurrentMap<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    public MemoryCandidateRepository() {
        save(new Candidate(0, "Ivan", LocalDateTime.now(), "job4j"));
        save(new Candidate(0, "Andrey", LocalDateTime.now(), "job3j"));
        save(new Candidate(0, "Konstantin", LocalDateTime.now(), "job2j"));
        save(new Candidate(0, "Alex", LocalDateTime.now(), "job1j"));
    }

    @Override
    public Candidate save(Candidate candidate) {
        candidate.setId(nextId.incrementAndGet());
        candidates.put(candidate.getId(), candidate);
        return candidate;
    }

    @Override
    public boolean deleteById(int id) {
        return candidates.remove(id) != null;
    }

    @Override
    public boolean update(Candidate candidate) {
        return candidates.computeIfPresent(candidate.getId(), (id, oldCandidate) -> new Candidate(oldCandidate.getId(),
                candidate.getName(), candidate.getDateTime(), candidate.getDescription(),
                candidate.getVisible(), candidate.getCityId())) != null;
    }

    @Override
    public Optional<Candidate> findById(int id) {
        return Optional.ofNullable(candidates.get(id));
    }

    @Override
    public Collection<Candidate> findAll() {
        return new ArrayList<>(candidates.values().stream().toList());
    }
}
