class Bill {

    public Date date;

    public Set payments;

    public Set positions;

    public Set calculateDues() {
        throw new UnsupportedOperationException("Not yet implemented");
 }

    public Set personsOnBill() {
        Set persons = new HashSet();
        for (BillItem item : this.positions) {
            for (BillItemShare share : item.shares) {
                persons.add(share.consumer);
            }
        }
        return persons;
    }

}

class BillItem {
    BillItem(final String newName, final double newPrice) {
        this.name = newName;
        this.price = newPrice;
    }

    public String name;
    public double price;
    public Set shares;
}

class BillItemShare {
    BillItemShare(final double newDue, final Person newConsumer) {
        this.due = newDue;
        this.consumer = newConsumer;
    }

    public double due;
    public Person consumer;
}

class PaymentShare {
    PaymentShare(final double newAmount, final Person newPayer) {
        this.amount = newAmount;
        this.payer = newPayer;
    }

    public double amount;
    public Person payer;
}

class Person {
    Person(final String newFirstName, final String newFamilyName) {
        this.firstName = newFirstName;
        this.lastName = newFamilyName;
    }

    public String firstName;
    public String lastName;

    public boolean equals(final Object o) {
        return (o instanceof Person)
                &&
                (this.firstName.equals(((Person) o).firstName))
                &&
                (this.lastName.equals(((Person) o).lastName));
    }

    public int hashCode() {
        return (this.firstName.length() << 4) | this.lastName.length();
    }

    public String toString() {
        return '[' + this.firstName + ',' + this.lastName + ']';
    }
}
