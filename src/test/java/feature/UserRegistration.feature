Feature: User Registration 
 I want to check that user can register in e-commerce website.
 
 Scenario Outline: User Registration 
 
 Given the user in the home page 
 When click on registration link 
 And enter "<firstname>","<lastname>","<email>","<password>" 
 Then user register successfully
 
 Examples:
 | firstname | lastname | email | password | 
 | Nahla| Elsayed| nahlaaaa3@test.com | 123456|,
 | Noha| Elsayed| nohaaaa3@test.com | 123456|
 
 