package lotto.domain;

import java.util.*;

public class WinnerNumbers {

    private final Set<LottoNumber> numbers;

    public WinnerNumbers(String lottoNumbers) {
        this(LottoNumbersParser.parseToSet(lottoNumbers));
    }

    public WinnerNumbers(Set<LottoNumber> lottoNumbers) {
        LottoValidator.validLottoNumbers(lottoNumbers);
        this.numbers = Collections.unmodifiableSet(lottoNumbers);
    }

    public LottoResults matchLottos(List<Lotto> lottos) {
        Map<Rank, Integer> matchStats = new HashMap<>();
        initializeMatchStats(matchStats);
        markResults(matchStats, lottos);
        return new LottoResults(matchStats);
    }

    private void initializeMatchStats(Map<Rank, Integer> matchingStats) {
        Arrays.stream(Rank.values())
                .forEach(rank -> matchingStats.put(rank, 0));
    }

    private void markResults(Map<Rank, Integer> matchStats, List<Lotto> lottos) {
        lottos.forEach(lotto -> this.markResult(matchStats, lotto));
    }

    private void markResult(Map<Rank, Integer> winningStats, Lotto lotto) {
        int matchCount = this.matchCount(lotto);
        this.markRank(winningStats, matchCount);
    }

    private int matchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }

    private void markRank(Map<Rank, Integer> winningStats, int matchCount) {
        Rank rank = Rank.findByMatchCount(matchCount);
        winningStats.compute(rank, (k, v) -> v + 1);
    }
}
