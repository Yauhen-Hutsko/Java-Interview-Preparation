import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TransferIdempotencyStarter {

    /* * Represents one request received by the payment API. */
    record TransferRequest(String requestId, String idempotencyKey, String fromAccount, String toAccount,
                           BigDecimal amount, Instant receivedAt) {
    }

    /* * Represents the canonical request accepted for an idempotency key. */
    record AcceptedTransfer(String idempotencyKey, String requestId) {
    }

    /* * Final reconciliation result. */
    record ReconciliationResult(List<AcceptedTransfer> accepted, List<String> conflictingKeys) {
    }

    static class IdempotencyService {
        public static void main(String[] args) {
            List<TransferRequest> requests = testData();
            IdempotencyService service = new IdempotencyService();
            ReconciliationResult result = service.reconcile(requests);
            System.out.println("Accepted transfers:");
            result.accepted().forEach(a -> System.out.println(a.idempotencyKey() + " -> " + a.requestId()));
            System.out.println();
            System.out.println("Conflicting keys:");
            result.conflictingKeys().forEach(System.out::println);
        }

        /* * Verification data.
         * Expected:
         * K1 -> R1
         * K2 -> conflict
         * K3 -> R5
         * Notice:
         * K1 contains 100.00 and 100.0.
         * These must be considered numerically equal.
         */
        private static List<TransferRequest> testData() {
            return List.of(
                    new TransferRequest("R1", "K1", "ACC-100", "ACC-200",
                            new BigDecimal("100.00"), Instant.parse("2026-11-20T09:00:00Z")),
                    new TransferRequest("R2", "K1", "ACC-100", "ACC-200",
                            new BigDecimal("100.0"), Instant.parse("2026-11-20T09:00:05Z")),
                    new TransferRequest("R3", "K2", "ACC-300", "ACC-400",
                            new BigDecimal("500.00"), Instant.parse("2026-11-20T09:01:00Z")),
                    new TransferRequest("R4", "K2", "ACC-300", "ACC-400",
                            new BigDecimal("550.00"), Instant.parse("2026-11-20T09:01:03Z")),
                    new TransferRequest("R5", "K3", "ACC-500", "ACC-600",
                            new BigDecimal("250.00"), Instant.parse("2026-11-20T09:02:00Z")));
        }

        public ReconciliationResult reconcile(List<TransferRequest> requests) {
            // TODO 1:
            // Handle null input safely.
            if (requests == null || requests.size() == 0) {
                throw new Exception("Collection is empty", requests);
                log.warn("no requests was found");
            }

            // TODO 2: Remove invalid requests.
            // A valid request must have:
            // - non-null request
            // - non-blank idempotency key
            // - non-null positive amount
            // - non-null receivedAt

            // TODO 3: Group requests by idempotencyKey.
            // Requirement:
            // Keys must be processed in ascending order.
            // Hint:
            // Collectors.groupingBy(...)
            // TreeMap::new

            // TODO 4:
            // For every idempotency key determine whether all requests have the same business payload.
            // Business payload consists of:
            // - fromAccount
            // - toAccount
            // - numeric amount
            // Important: 100.0 and 100.00 must be considered equal.

            // TODO 5:
            // If different business payloads exist under
            // the same idempotency key, add that key to
            // conflictingKeys and ACCEPT NOTHING for it.

            // TODO 6:
            // For a non-conflicting key select exactly one // canonical request: // // 1. earliest receivedAt // 2. if timestamps are equal, lowest requestId

            // TODO 7:
            // Return:
            // - accepted transfers
            // - conflicting keys
            //
            // Both should follow ascending idempotency-key order.
            return new ReconciliationResult(List.of(), List.of());
        }

        /* * Candidate may implement a helper here. * * Suggested purpose: * Check whether every request in a group has * equivalent business data. */
        private boolean consistent(List<TransferRequest> requests) {
            // TODO
            return false;
        }

        // I've start writing help method for TODO 2
        private List<TransferRequest> requestValidation(List<TransferRequest> requests) {
            requests.stream()
                    .filter(request != null)
                    .filter(String::isEmpty)
                    .filter(x -> x > 0)
                    .asList();
        }
    }
}
}