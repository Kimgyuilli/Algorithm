import java.util.*;

class Solution {
    
    private class Employee {
        private String name;
        private int salary;
        private Employee parent;
        
        Employee(String name) {
            this.name = name;
            this.salary = 0;
        }
        
        public void setParent(Employee parent) {
            this.parent = parent;
        }
        
        public void updateSalary(int money) {
            int tax = money / 10;
            this.salary += money - tax;
            
            if(parent != null && tax > 0) {
                this.parent.updateSalary(tax);
            }
        }
        
        public int getSalary() {
            return this.salary;
        }
    }
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int len = enroll.length;
        Map<String, Employee> enrollment = new HashMap<>();
        
        for(int i = 0; i < len; i++) {
            Employee e = new Employee(enroll[i]);
            enrollment.put(enroll[i], e);
            
            if(!referral[i].equals("-")) e.setParent(enrollment.get(referral[i]));
        }
        
        for(int i = 0; i < seller.length; i++) {
            int money = amount[i] * 100;
            Employee emp = enrollment.get(seller[i]);
            emp.updateSalary(money);
        }
        
        int[] answer = new int[len];
        
        for(int i = 0; i < len; i++) {
            answer[i] = enrollment.get(enroll[i]).getSalary();
        }
        
        
        
        return answer;
    }
}