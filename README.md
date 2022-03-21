                    **API Test Framework**

Framework for API automation testing
- Rest APIs
- GraphQl APIs

**Example Used in framework:**
Used public rest and graphQl api to predict the age of a person based on their name.

**Core Framework import:**
User avis-api framework as dependency in pom.xml

**Automation Suite run commands**
- mvn clean install -DsuiteType=package  (This will run all test packages under system tetsing)
- mvn clean install -DsuiteType=package -DTestingType=agePredictor  (This will run all test under systemTesting.agePredictor package)
- mvn clean install -DsuiteType=group -DTestingType=restApi  (This will run all tests tagged with group name restApi under systemTesting package)
- mvn clean install -DsuiteType=group -DTestingType=graphQl  (This will run all tests tagged with group name graphQl under systemTesting package)
- mvn clean install -DsuiteType=group -DTestingType=regression  (This will run all tests tagged with group name regression under systemTesting package)
- mvn clean install -DsuiteType=system  (This will run all test cases in systemTesting package)