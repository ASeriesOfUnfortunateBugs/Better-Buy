# Better Buy

This was the final project in the web applications program at my school. The purpose of the project was to show that I and my fellow students had fully learned the tools necessary to develop an application as part of a team. Passing this class was a requirement for graduation so we all put everything we had into this project.

Better Buy is an e-commerce web app built with HTML, Bootstrap, JQuery, and Java. The course instructor assigned students to each team, assigned a theme for the application, and set the requirements. Our instructions were to build an e-commerce web app for an electronics retail company. The requirements were as follows:

* Customers should be able to browse the products on the website
* Customers should be able to make purchases without creating an account
* Customers should have the option of creating an account
* Customers should be able to check out using the information on their account
* Customers should be able to view and make changes to the information on their account
* There should be a products page and a sales page
* There should be an admin account that is accessible via the login page
* There should be an admin only page
   * The admin page should have a table showing order information from the database
   * The admin should be able to change the status of the orders, indicating whether they have been readied, shipped, or picked up

We were not given any starting code or databases for this project. Everything we did was designed and developed from scratch.

- - -

Our first decision regarding this project was how we wanted to approach the development process. We decided on a hybrid Agile approach where we would meet online via Discord every week to discuss our progress and assign duties. We divided our team of five students into a front-end team and a back-end team. While technically part of the front-end team, I functioned in more of a full-stack capacity as I lent a hand to the back-end team whenever necessary. Additionally, after the initial design phase, the database became my responsibility. I also worked with one of the back-end developers at the end of the project to compile the project files into a working NetBeans project with access to the local server so we could all contribute to the video presentation at the end of the semester.

Once we decided on a framework for developing our project, we moved into the design phase. We started with a brainstorming session where we identified our business objects and database needs. We also made the decision to build the back-end using Java as it was the programming language we all had in common. During this meeting we also worked out what pages we would need for the front-end, and I created a use case diagram and page diagram. (The file containing our notes for the database design can be found in design phase/01. database design.md. The use case diagram and page diagram can both be found in the design phase folder as well.)

Our work for that week consisted of each of us writing up a section of the database. I was responsible for writing the SQL for the Products and Orders tables as well as sourcing and populating the Products table with data for the Products page. (These files can also be found in the design phase folder.)
Additionally, I created a shared space on Github for us to upload our project files to. As the only one who had used Github in the past, I gave everyone a crash course on how to access the files and upload their work.

While the back-end team got to work on their portion of the project, the front-end team focused on the UI design. Each of us made a mock-up that we could present to the team, then we held a vote for which design we would use. (Though my design wasn't picked, I have uploaded my mock up to the design phase folder. The design was done in Figma.)

With the design stage completed, we moved on to development. We each chose which pages we would like to work on. Since I had more experience with full-stack development, I chose the pages that I thought would require more understanding of how to tie the front-end and back-end together. I chose the login page, the account creation page, the admin homepage, and the orders page. My previous experience with back-end design came from the PHP and Web Development classes I took earlier in the web app development program. Despite only having experience with PHP, I was able to learn how to make those same connections in Java since I already had a strong understanding of the concepts and processes required. I was able to work with the back-end team to ensure that my account creation and login forms interacted with the database as required. Additionally, I did a ton of other research into how to write the orders page to dynamically load information from the database. No one else on the team knew how to do this so I had to use online resources to figure it out for myself. (The orders.html file in the web folder is the one I wrote with dummy data for the purposes of showing the team how I chose to design the table and form. The orders.jsp file is the actual file used to access the database and populate the table.)

At this stage in the development, we hit a few snags. One of the other team members accidentally overwrote a bunch of files in the repo. Luckily, I had been keeping a back up of the repo up to date just in case this happened. I was able to recover the original files from this back up and add the updated files safely to the repo. Thankfully I had finished coding my portion of the project at this point so I had enough time to get everything sorted.

With my portion of the project completed and the repo back in working order, I began the debugging process and carefully checked the UI to ensure consistency across all pages.

Once the rest of the team had turned in their work, the final step was to compile the files into a NetBeans project and ensure that each team member could run the server and access the web app through NetBeans. I worked with one of the back-end team members for this step, figuring out exactly how to configure the project so that everything would function as expected for everyone. Working together, we were able to get that sorted in time for the presentation, which marked the end of development.

If you would like to see a demostration video for this project, [I have one available here](https://youtu.be/hTtq9Ars7Bc).
