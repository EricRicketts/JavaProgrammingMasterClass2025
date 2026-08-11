package org.example;

public class StoreEmployee extends SecondEmployee {

    private String store;

    public StoreEmployee() {
    }

    public StoreEmployee(int employeeId, String name, int yearStarted, String store) {
        super(employeeId, name, yearStarted);
        this.store = store;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public class StoreComparator<T extends StoreEmployee>
            extends SecondEmployee.SecondEmployeeComparator<SecondEmployee> {

        public StoreComparator(String sortType) {
            super(sortType);
        }

        public StoreComparator() {
            super();
        }

        @Override
        public int compare(SecondEmployee o1, SecondEmployee o2) {
            int compareEmployeeStores = 0;
            if (o1 instanceof StoreEmployee s1 && o2 instanceof StoreEmployee s2) {
                compareEmployeeStores = s1.getStore().compareTo(s2.getStore());
            }

            if (compareEmployeeStores != 0) {
                return compareEmployeeStores;
            }

            return super.compare(o1, o2);
        }
    }
}
