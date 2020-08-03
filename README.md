# F21ASFinalProject

Stage 2 - JAVA Projct - Airport Check-In System 

To apply thread-based programming, design patterns and agile methodology to the Airport Check-in System from Stage 1 and extend the application to simulate passengers queuing at check-in desks and being assigned to waiting planes. The application included the development of a suitable GUI to show the state of the simulation. 

A summary of the implemented core functional requirements: 
1.	Implementation of check-in desks, a single passengers queue, and a group of flights waiting for departure. 
2.	Reading passengers/booking details and flights details at the startup of the program, in addition to assigning random baggage details to each passenger. 
3.	Processing of passengers check-in by randomly selecting passengers from the back of the queue and assigning them to their appropriate flights. 
4.	Each check-in desk will process booking details in a specified amount of time, and the whole check-in process will be allowed only for a specified amount of time, after that the passenger cannot check-in any more. 
5.	The GUI shows the simulation of passengers queue, check-in desks and flights statuses. 
 
Extending the core functional requirements:
We have added the following extended features:
1.	Allow the user to alter the speed of simulation predefined values assigned to each check-in desks and can be changed from the timer implemented using System.nanoTime() method.
2.	Adding a timer to limit the total amount of time for the check-in process. ThereforeTherefore after the time is up; the passengers will no longer be able to check-in. 

