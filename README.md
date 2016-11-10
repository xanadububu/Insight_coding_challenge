#Usage
1.Java was used for this problem. Java VM version is:

	Java version "1.8.0_111"

	Java(TM) SE Runtime Environment (build 1.8.0_111-b14)

2.Original repo directory structure is preserved, /insight_testsuite was not used. 

All Java codes are under /src,  and run.sh is modified for compiling and running Java codes.

	Test input is under /paymo_input:
	batch_payment_t3.csv
	stream_payment_t3.csv

	Test output is under /paymo_output:
	output_t1.txt
	output_t2.txt
	output_t3.txt
The full ~4M entry batch_payment.csv and selected ~100K entry from stream_payment.csv were also tested.

#Notes
Current design is first generating friend relation map to store the direct (1st-degree) friend of every ID from payment history by FriendMap.java. And then check the friend relationship (feature 1~3) by checkFarud.java.

Altenative design could be:

1. Generate friend relation maps of 1st-degree, 2nd-degree and 4th-degree friends respectively, or add another dimension of the map to accomodate all these information. But this required more memory to hold the map and will increase initialization time to generate the friend map.

2. Since the userID is consecutive integer, we can store the friend relation into array and use senderID as array index, this may provide even faster fraud check.

Current design tried to ballance the initialization time, memory usage and fraud check speed.
