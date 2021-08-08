object bankProgram extends App {
	var bank: List[Account] = List()

	// Find accounts with negative balance
	val overdraft = (b: List[Account]) => b.filter(x => x.balance < 0)

	// Total
	//val total = (b: List[Account]) => b.reduce((x, y) => (x.balance + y.balance))

	// Intrest
	val interest = (b: List[Account]) => b.map(x => if(x.balance > 0) x.deposit(x.balance*0.05) else x.deposit(x.balance*0.1))

	// display list - To display bank details globally
	def displayList(lst: List[Account]) = {lst.foreach(i => i.display())}


	class Account(id: String, n: Int, b: Double) {
		val nic = id
		val accNumber = n
		var balance = b

		bank = bank :+ this

		def withdraw(x: Double) = {this.balance = this.balance - x}

		def deposit(x: Double) = {this.balance = this.balance + x}

		// Transfer deposit to another account
		def transfer(a: Account, amount: Double) = {
			val acc = bank.filter(x => x==a)
			acc.head.deposit(amount)
			println("amount transfered successfully!")
		}

		// display account - To display account details globally
		def display() = println("nic: " + nic + " acc: " + accNumber + " balance: " + balance)
	}

	// INSTENTIATE OBJECTS
	val user1 = new Account("199931712165", 11111, 20000.00)
	user1.display()
	val user2 = new Account("200012568759", 22222, 50000.00)
	user2.display()
	val user3 = new Account("199845698712", 33333, -1000.00)
	user3.display()

	// MONEY TRANSFERING
	println("\nTransfer 5000.00 from account 11111 to account 22222")
	user1.transfer(user2, 5000.00)
	user2.display()

	// CHECK ACCOUNTS WITH NEGATIVE VALUES
	println("\nAccounts with negative values")
	displayList(overdraft(bank))

	// TOTAL BALANCE OF ALL ACCOUNTS
	//println("\nTotal balance of all accounts")
	//println(total)

	// APPLY INTERST FOR EACH ACCOUNT IN THE BANK
	println("\nAccounts after interest applied")
	interest(bank)
	displayList(bank)
}