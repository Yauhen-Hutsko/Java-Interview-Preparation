// Wipro interview (?) — Spring @Transactional snippet shown during the interview.
// Code as given; no question text or answer recorded. See README.md.

@Service
public class PaymentService {

    public void process() {
        savePayment();
    }

    @Transactional()
    public void savePayment() {
        // DB update
    }
}
