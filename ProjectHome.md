CSC4370

Fall 2010
Project 3 (Due December 5th)
E-Commerse Using Java-MVC

Create the shopping cart application. This is a standard ecommerse application. There are users and an inventory. As a user selects items from tte inventory, they are added to their shopping cart. When the user checks out, the shopping cart is turned into an order.

Use the MVC framework to model your application. This means you will use JSP for your views, Servlets for control, and beans for the model.

Sample Code

Project Pieces Views

Views(jsp/html)	Controlls(Servlets)	Models(DB/Beans)
Main
Menu
Login
Inventory
ViewCart
Profile
Register
Menu
Login
Addtocart
Checkout
Register
DB Use the following tables
Customers
Inventory
Orders
Beans
User
ShoppingCart
DB
Interaction Views

Views	Submits to:	Access Models
menu.jsp	Menu.java	-
login.jsp	Login.java	User.java
inventory.jsp	Addtocart.java	DB
viewcart.jsp	-	Shoppingcart.java
profile.jsp	-	DB User.java Shoppingcart.java?
register.jsp	Register.java	-


Interaction Controls

Control	Forward To	 Models(Update/Access)
Menu.java	**-
Login.java	main.jsp/login.jsp	User.java/DB
Addtocart.java	viewcart.jsp	Shoppingcart.java
Checkout.java	profile.jsp	DB/Shoppingcart.java
Register.java	main.jsp/register.jsp	DB, User.java
other	-	-
Descriptions**

Views	Desc.	Displays
menu.jsp	A small jsp file included on other pages	Links
login.jsp	Standard login page	Failed attempts
inventory.jsp	A refliction of the inventory, used to add to the cart	DB:Inventory table
viewcart.jsp	Shows the status of the current shopping cart with a total	Shoppingcart.java
profile.jsp	Personal info plus list of past purchases	DB: table
register.jsp	New user	-
Use Cases

Case	Interacts with	Results
Login	Login.java	User bean updated
Browse Inventory	DB:Inventory is read
Add to cart	Addtocart.java
Check out	Checkout.java, Shoppingcart.java	DB:Orders updated
View Profile	-	DB User.java Shoppingcart.java?
register.jsp	Register.java	-


Requirements:

See above
Stuff
Things
Be prepared to present in class.

Back to Projects