package aPatternsCode;

import java.util.List;

abstract class Employee1 {
	abstract void visit(EmployeeSorter visitor);
	// ...
}

class Engineer extends Employee1 {
	@Override void visit(EmployeeSorter visitor) {
		visitor.visit(this);
	}
	// ...
}

class Manager extends Employee1 {
	@Override void visit(EmployeeSorter visitor) {
		visitor.visit(this);
	}
	// ...
}

class Salesman extends Employee1 {
	@Override void visit(EmployeeSorter visitor) {
		visitor.visit(this);
	}

	// ...
}
interface EmployeeSorter {
	void visit(Engineer engineer);
	void visit(Manager engineer);
	void visit(Salesman engineer);
	
}
class VisitorEmployeeSorter implements EmployeeSorter {
	private List<Engineer> engineers;
	private List<Salesman> salesmen;
	private List<Manager> managers;
	void sortEmployee(Employee1 emp) {
		emp.visit(this);
	}
	// ... Other functions and variables
	@Override public void visit(Engineer engineer) {
		engineers.add(engineer);
	}
	@Override public void visit(Manager manager) {
		managers.add(manager);
	}
	@Override public void visit(Salesman salesman) {
		salesmen.add(salesman);
	}
}

