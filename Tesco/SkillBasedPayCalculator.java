// Tesco — Skill-Based Pay Calculator (WIP). Task: see README.md
import java.util.List;

class SkillBasedPayCalculator {
    public static void main(String[] args) {

        List<Shifts> shifts = List.of(new Shifts(1001, "Bakery", 8), new Shifts(1003, "Security", 4));
        Employee e1 = new Employee(1001, shifts, "permanent");
        Employee e2 = new Employee(007, shifts, "Permanent");

        System.out.println(skillBasedPaymentCalculator(List.of(e1, e2)));
    }


    static List<String> skillBasedPaymentCalculator(List<Employee> employees) {
        for (Employee employee : employees) {
            long extraRewards = 0;  //store reward for every skill.
            List<Shifts> shifts = employee.getShifts();
            for (Shifts shift : shifts) {
                String skill = shift.getSkill();
                switch (skill) {
                    case "Bakery":
                        extraRewards = +(long) 2 * shift.getDuration();
                        break;
                    case "Cleaning":
                        extraRewards = +(long) 1 * shift.getDuration();
                        break;
                }
            }
            double totalReward = extraRewards + employee.getBaseSalary();
        }
        return null;
    }

    public static class Employee {
        int id;
        List<Shifts> shifts;
        String contractType;
        double baseSalary;

        public Employee(int id, List<Shifts> shifts, String contractType) {
            this.id = id;
            this.shifts = shifts;
            this.contractType = contractType;
            this.baseSalary = setBaseSalary(contractType, shifts);
        }

        public int getId() {
            return id;
        }

        public List<Shifts> getShifts() {
            return shifts;
        }

        public String getContractType() {
            return contractType;
        }

        public double getBaseSalary() {
            return baseSalary;
        }

        private double setBaseSalary(String contractType, List<Shifts> shifts) {
            int totalHours = 0;
            double multiplicator = 0;
            for (Shifts shift : shifts) {
                totalHours = +shift.getDuration();
                switch (contractType) {
                    case "Permanent":
                        multiplicator = 12.5;
                        break;
                    case "Agency", "Zero-hours":
                        multiplicator = 13;
                        break;
                }

            }
            return totalHours * multiplicator;
        }

    }

    public static class Shifts {
        int id;
        String skill;
        int duration;

        public Shifts(int id, String skill, int duration) {
            this.id = id;
            this.skill = skill;
            this.duration = duration;
        }

        public int getId() {
            return id;
        }

        public String getSkill() {
            return skill;
        }

        public int getDuration() {
            return duration;
        }
    }
}


//class TestScratch {
//
//    public void skillBasedPaymentCalculatorTest (){
//        List<SkillBasedPayCalculator.Shifts> shifts = List.of(new SkillBasedPayCalculator.Shifts(1001, "Bakery", 8), new SkillBasedPayCalculator.Shifts(1003, "Security", 4));
//        SkillBasedPayCalculator.Employee e1 = new SkillBasedPayCalculator.Employee(1001, shifts, "permanent");
//        SkillBasedPayCalculator.Employee e2 = new SkillBasedPayCalculator.Employee(007, shifts, "Permanent");
//        List<String> list = SkillBasedPayCalculator.skillBasedPaymentCalculator(List.of(e1));
//
//        Assertions.assertEquals(8*2+4, Integer.valueOf(list.get(0)));
//
//    }
//}