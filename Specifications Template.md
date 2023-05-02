# MyFairLady-v1.000.2-
Say hello to Patricia '23.

IT PAT 
Specification Document
MyFairLady(v1.000.2)











<PICTURE HERE>

















Name:
Neeraav Ranjit
Grade:
12






Contents:

1. Problem summary	3
2. Motivation and Research	4
2.1. Existing solution	4
2.2. How my project will differ from the current available programs	4
3. Specifications of program functionality	5
3.1. <Screen 1/section 1> function specifications	5
3.2. <Screen 2/section 2> function specifications	5
3.3. <Screen n/section n> function specifications	5
4. Specifications of interface	6
4.1. Theme	6
4.2. Font	6
4.3. Screen layout	6
4.3.1. <Screen 1/section 1> UI specifications	6
4.3.2. <Screen 2/section 2> UI specifications	6
4.3.3. <Screen n/section n> UI specifications	6
5. Specifications of help	7
6. Specifications of permanent data storage	8
7. Hardware and software requirements	9
7.1 Programmer Requirements	9
7.1.1 Software	9
7.1.2 Hardware	9
7.2 User Requirements	9
7.2.1 Software	9
7.2.2 Hardware	9


1. Problem summary

The purpose of my project is to facilitate the management, and record keeping of Events ,exhibitions and . Particularly useful for Owners of Events such as Charity Fairs , Fun fairs, or any kind of event where there are multiple levels of management which focus on selling products and services.It is a program designed to digitise all records so that they may be recorded easier, and therefore calculations about statistics such as profits, losses , sale prices, cost prices ,number of people who entered, entrance fees can be automatically performed. Furthermore, it can also track informative information such as trading hours, fees, store owners, fair owners, admins, most profitable stores/fairs.

The Functions of this program can be broken down into 3 sections, The uppermost level , the admin manager section which allows an administrator to ,for example, create a fair for a company. A fair owner, who can create an exhibition/fair/event and lastly a store owner who operates under the fair owner.

The Admin manager can create fair owner/exhibition owner accounts, and manage/oversee all fairs, create new fairs/exhibitions/and delete them.This screen will show a list of fair/exhibition names. Total profits made from all stores under the fairs, most popular fairs etc.

A fair owner may create and assign stores under their exhibitions.They can distribute store owner accounts and oversee all stores/setups in the exhibition.They can sort or view the most profitable or most popular ones and have live updating values.

Once given the account, a store owner will have access to a section of the app which handles the management of their respective store. This can allow them to add or remove products and services they want to sell. They can sell their items and 


edit their prices. Furthemore, the app will track their inventory and notify the owner whenever they are out of 
stock.The app allows a store owner to view their sale history and they will be given a list of all sales and allowed to sort through them for any reason they have.Lastly, they will be allowed to view statistics of the store, such as total sales, total cost, total profit,most popular item, most profitable trading day.
































2. Motivation and Research

2.1. Existing solution

Event Pro
A current existing solution to fair/exhibition events is called EventPro which basically does all of my project’s with the additions of Floor management, venue management,staff management.It also has things such as communication logs, budget managers and Schedulers.

Clear Event
Clear event also does what my program does, sales and booth/store management.Theres an in-app dashboard, payment management,invitation management, employee registration, as well as customer support.

References:
Trade Show and Exhibition Management Software Available at: https://www.eventpro.net/fair-exhibition-booth-management-software.html
(Accessed: March 12, 2023).

Event Planning Simplified Available At:
https://clearevent.com/
(Accessed: March 12,2023)

2.2. How my project will differ from the current available program

The motivation behind my project was during my time of community service for the Winter Fair hosted by child welfare.It is a fun fair with carnival rides, games and stores with food, services, clothes etc. I had noticed how inefficient it was , having to manually double check, add and count your sales.This caused store owners, and fair owners to stay up until early hours of the morning ensuring that the money was correctly counted.Having a software that can automatically do this and being on the go would be beneficial to the winter fair but also much more.For example, this could be used on a school’s market day, a small scale event, where kids could track how much stock they have left and how much money they SHOULD have based on how much they have sold.

//we’ll come back to the differences later.






3. Specifications of program functionality


3.1. Admin Manager specifications

<Write a bulleted list of what this section of the program is responsible for. Each item listed here will probably become a function.>

Should have a view of all fairs/exhibitions
Should be able to add a fair/exhibit
Should be able to delete fair/exhibit
Should be able to sort by fairs/exhibit
Should be able to add a fair/exhibit/expo owner account
Should be able remove a fair/exhibit/expo owner account


3.2. Fair Manager specifications
Should be able to view all stores/setups and sort by certain properties of this fair/exhibition
Should be able to add stores/setups
Should be able to remove stores/setups
Should Be able to add different kinds of employees or a staff list
Create and or edit the shape and layout of your fair
Move your stores/exhibits
Have a counter of how many people have entered
Have set an entrance fee
Be able to add or remove stores from the fair
Be able to create store owner accounts
Have a statistics screen with total profit of the fair, most popular stores etc
Have a to-do-list , for example, to see whether a certain booth/store/exhibit has sent in their stats/results
Have a status of the exhibits/stores/booths to see whether they are operational, or closed or interrupted or short staffed etc
An announcement board that all store owners can see




3.3. Store Manager specifications
Should be able to add or remove products or services they want to sell
Should be able to set the status of their store
Should be able to have a logbook which contains the products or services they sold, and the date at which they should
Should have a stats screen to view properties such as most popular product or total profit
Should be able to add or remove to work under them
Should be able to make a sale
Should be able to make an announcement which all members of hte fair can see, such as a need for staff
 

3.4. Login specifications

User should be able to simply enter in a username and password and access their store or fair or admin section


4. Specifications of interface

4.1. Theme

The theme for this app will be under the “embers” colour palette. It is 4 subtle colours as shown below that will be used across all screens with a combination of white/grey text.

41436A







984063







F64668







FE9677










4.2. Font

<Define the font and size for the following: Title, heading 1, heading 2, heading 3, normal text>

Title - AmbarPearl(Its a custom font) - size 40
Heading 1 - Gadugi BOLD - size 24
Heading 2 - Gadugi BOLD - size 18
Heading 3 - Gadugi BOLD - size 14
Normal text - Gadugi BOLD - size 14

4.3. UI Component

4.3.1. <Admin Manager Section> UI specifications

<Write a bulleted list of the main UI components, input components and sections that you will need on each screen (make sure to think of the type of the data entered)>

Fair Management Panel/card
JTable - to view the fairs
A combo box to sort by certain properties
2 Text Fields to create a fair(name and entrance fee)
A Jist to prove a list of available fairs to delete
A button to delete the fair
A button to add a fair

User Management Panel/card
2 Text fields to input a username and password
A Combo Box which contains the fair that you would like to allocate this fair owner to
Another combo box with a list of fair owners, 
A Jbutton to add a fair owner
A Jbutton to delete a fair owner


4.3.2. <Fair Manager Section> UI specifications

Entrance Management Card:
A Jspinner for the amount of people entered
A jtable for the log of people entering

	Store/exhibit Manager
A Jtable to show all current stores
A Jlist with all the available stores
A button to delete a store
Text fields to create a store, anf store owner account as well as category, 
A button to add the store

	Fair Layout Manager
JPanels to represent ht layout of stores on the fair

	Staff Management
A Jtable showing all available stafa , there current occupation, level, presence , and availability, name, surname etc.
 Text fields to create staff members
Button to remove staff members
Button to add staff member

	Announcements Card

A Huge Text field that can be used to send announcements to all the stores/exhbits in your event
A send button

	Statistics Card

Text fields for stats such as total profit, number of customers, most profitibale store,income today , average over last week etc.

4.3.3. <Store Owner> UI specifications

Sales card:
Jlist to select a product 
A spinner to select a quantity to sell
A sell button

	Inventory Card:
A Jtable with all the available products
TExt fields to add a product(name,qunaitity,cost price, selling price, category
An add product button
A remove produc button

	Employees card
A Jtable of all employees who wokr under this store
A combo box of the employees who can be added to this store

	Messages Card
A text field to receive anouncemnts from fair managers
Radio buttons to indicate status of the store, e.g closed, open, busy,short staffed etc.

	Stats card
Just a buinch of text fields with different properties about the store. E.g total profit, most popular product, least popular, number of customers, total income today, over a period of days, total costs, 






5. Specifications of help


There will be small instructions next to data inputs, with a description of what they should be putting into the field
There will be a message box that pops up when abnormal data is entered stating what the problem is , and how it should be dealt with
There could perhaps be a help screen?


6. Specifications of permanent data storage

<Write a short description of what data needs to be stored in permanent storage. This should describe WHAT data needs to be stored not necessarily the EXACT layout in permanent storage and not what type of permanent storage will be used (don’t mention database/text files).>

User
username: Name of the user to enter a level of the app
Password: to uniquely give access to th
Authority Level: EIther a store owner, fair owner or admin


Store
Store name
Store number
Category
List of products
List of Sales
Fair Name
Store Owner Username
status

Fair
Fair Name
List of Stores
Entrance fee
Duration
Fair Owner Username
Staff list
Shape of fair



Product/service 
Name
Store to which it belongs
Selling price
Cost price
Profit per product
category
Quantity owned
Quantity sold

Sale
List of Stock items and quantities sold
Date/time of sale
Store

User
Username
Password
Authority Level
Fair/store they owen



7. Hardware and software requirements


7.1 Programmer Requirements

7.1.1 Software

Windows 7 Professional (and later versions) Operating System
Java 8 V311 or later versions
Apache Netbeans 12.4 or later versions
Google Docs
MySQL Workbench (8.0) CE
Java MySQL Connector (8.0.31)

7.1.2 Hardware - (minimum requirements)

Processor: Any Dual core CPU @2.9Ghz
RAM: 2.00 GB(available)
Hard disk Space: Minimum 2 GB(Available)


7.2 User Requirements

7.2.1 Software
Windows 7 Professional (and later versions) Operating System
Java 15 or later versions
Apache Netbeans 12.4 or later versions
7.2.2 Hardware
Processor: 1.90GHz or faster
RAM: minimum 0.2 GB(Available)
Hard disk Space: Minimum 50 MB(Availavble)

