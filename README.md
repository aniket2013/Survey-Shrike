# Welcome to Survey Shrike Survey Application
Survey-Shrike is a web application that allows users to create any sort of survey of forms ranging across any domain. This appliation aims to provide the most generic and scalable solution to create survey forms across different domains ranging from medical to finance , public sourced projects to sophisitcated govenrment or private projects you name it this web application allows you to achieve it. Following are it's major features:

 

 1. Allows the users to create a survey form by a simple and lucid apporach. The user needs to just specify the questions he/she wants to ask in the survey and then select the paceholders for the answers to the questions.Following are the list of entities he can create:
   - Name Of the Survey
   - Single Line Input
 - Multi Line Input
 - Drop Down Input
 - Check Box  Input
 - Upload Button Option
 
2. Save the forms that are created with a validation rule that no 2 survey forms can have same name.
3. Scalability for the future by providing the algorithms that can be used to carry out data analytics on the repsonse provided by the particpants on the survey questions. Those can help us to design models that can try predicting the future surveys to be carried out. Following natural language processing algortihms have ben provided:
    - Jaro Strategy Algorithm
   - Jaro Winkler Algorithm
   - Levenshtein Algorithm
   - Dice Coefficient Strategy Algortihm
   Further it also provides a faciltiy to show different statistics regarding the survey forms.

4. Comes with a simple but reusable memeory architecture that can easily be extended to most of the problem statements pertaining to this domain.
5. Secured using the Spring Security that has a pretty elaborte mechanism to provide authorization and authentication for the usage of the application.
6. The functionality of the feature has been carried out in accordance with the microservices architecture. There are end points that can easily be used by other applications of same or different domains.The end points shave been desing adhering to the principles of reusability and maintainablity keeping in mind scalability.
7. Comes with a swagger documentation for the API.
8. Quality wise - Implemented in Test Driven Development and Behavioural Driven Development so it includes all the facets required for a quality wise solid application.


Following are the technical details about the project:
     
#  Technical Design

Following are the three main components:
   

 1. Database architecture
 2. Spring Security
 3. Microservices
 

## Database architecture

![alt text](https://github.com/aniket2013/Survey-Shrike/blob/master/TechnicalDesigns/DatabaseArchitecture.JPG)

##  Spring Security
![alt text](https://github.com/aniket2013/Survey-Shrike/blob/master/TechnicalDesigns/Security.JPG)

##  Micro Services
![alt text](https://github.com/aniket2013/Survey-Shrike/blob/master/TechnicalDesigns/MicroServices.JPG)

##  OverAll Design
![alt text](https://github.com/aniket2013/Survey-Shrike/blob/master/TechnicalDesigns/OverallDesign.JPG)


#  Micro Service End Points    
1.

     @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    	@ApiOperation(value = "Show the HTML rendered",
    notes = "Fetches the client side entities rendered to show the dashboard")
 This end point will render the dashboard where all operations can be performed and the survey forms are displayed.

2.`

    @ApiOperation(value = "Get all the forms",
    		    notes = "Fecthes the json contents of all the forms")
    	@RequestMapping(value = "/forms", method = RequestMethod.GET)

This end point will fetch the  data for all the forms that are present in the database. On the client side you would only see the names of the survey forms.

3. `

    @ApiOperation(value = "Get the form by form Id",notes = "Fecthes the json data of the form by Id passed")
    	@RequestMapping(value = "/form/formId", method = RequestMethod.GET)`@RequestParam String Id

This end point would fetch the data of a survey form by the formId.

4.`

    @ApiOperation(value = "Get the number of enrollements in a form",notes = "Number of enrollemts for a form based on the formId passed")
    	@RequestMapping(value = "/form/enrollments/formId", method = RequestMethod.GET)`@RequestParam String Id

This end point fetches the number of enrollments to a survey form base don their form Iid.
5. `@RequestMapping(value = "/form/saveForm", method = RequestMethod.POST)` @RequestParam String Id`
This end point saves or updates the survey form based on the form Id.

#  Quality Reports
## Test Driven Development-JUnit reports
![alt text](https://github.com/aniket2013/Survey-Shrike/blob/master/TDDReports/ControllerTest.JPG)   

![alt text](https://github.com/aniket2013/Survey-Shrike/blob/master/TDDReports/ServiceTest.JPG)

  
## Behavioural Driven Development-Cucumber Reports
![alt text](https://github.com/aniket2013/Survey-Shrike/blob/master/BDDReport.JPG)

![alt text](https://github.com/aniket2013/Survey-Shrike/blob/master/BDDReport1.JPG)
