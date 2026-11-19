// Account Structure:

// HH-SMITH
// ├── HUSBAND-SMITH
// │   ├── ACC-101
// │   └── ACC-102
// └── WIFE-SMITH
//     ├── ACC-201
//     └── ACC-202

// Basic Assumptions:
//  - Account structure is fixed and always correct
//  - Only leaf accounts can have proposed orders
//  -Querying any account must include orders from its descendants
//       - (query household code -> get all proposed orders)
//       - (query child code -> get orders from its child accounts)


public record Account(
        String accountCode,
        List<Account> children) {}

public record ProposedOrder(
        String accountCode,
        long scenarioId,
        long securityId,
        double quantity) {}
// ProposedOrder(Acc-101, 1, 111, 10) // buy 10 apple
// ProposedOrder(Acc-101, 1, 110, 10) // buy 10 microsoft
// ProposedOrder(Acc-101, 2, 110, 15) // buy 15 microsoft - other scenario
// ProposedOrder(Acc-101, 2, 111, 10) // buy 11 apple - other scenario


public class ProposedOrderResults {

    Map<Integer, ProposedOrder> foundByAccountAndScenario = new HashMap<>();
    Map<Integer, ProposedOrder> foundByAccount = new HashMap<>();
    Map<Integer, ProposedOrder> foundByScenario = new HashMap<>();

    Account householdId;
    List<ProposedOrder> proposedOrders;

    public ProposedOrderResults(Account household, List<ProposedOrder> proposedOrders) {

    }

    public List<ProposedOrder> findByAccountAndScenario(String accountCode, long scenarioId) {
        if(accountCode.isBlank() || scenarioId == 0 ){
            throw new Exception();
        }

        if(foundByAccount.size > 0){
            return foundByAccount;
        }else{
            for(order: proposedOrders){
                long hash = String.valueOf(accountCode+scenarioId).hashCode())
                if(order.accountCode==accountCode && order.scenarioId==scenarioId){
                    foundByAccountAndScenario.put(hash, order)
                }
                return foundByAccountAndScenario;
            }
        }

    }

    public List<ProposedOrder> findByAccount(String accountCode) {
        if(accountCode.isBlank()){
            throw new Exception();
        }

        if(foundByAccount.size > 0){
            return foundByAccount;
        }else{
            for(order: proposedOrders){
                if(order.accountCode==accountCode){
                    foundByAccount.put(accountCode, order)
                }
                return foundByAccount;
            }
        }
    }

    public List<ProposedOrder> findByScenario(long scenarioId) {
        if(accountCode.isBlank){
            throw new Exception();
        }
        if(foundByScenario.size > 0){
            return foundByScenario;
        }else{
            for(order: proposedOrders){
                if(order.scenarioId==scenarioId){
                    foundByScenario.put(scenarioId, order)
                }
                return foundByScenario;
            }
        }
    }