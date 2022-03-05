# ParallelAssignment2
<strong> Assignment repo for Dr. Devchev Parallel Programming Class </strong>
<p> Made by: Eduardo Bourget </p>
<p> 
For Part (1), the Procedure is the following:

- We have that all the students plan together and select one of them to declare wether all the students have visited the laborinth.
- Lets assume that the nominated student maintains the count of all the students that have entered the laborinth, we can let the count be 1 initially.

- Starting journey, we have two cases
    - Case 1 "When there is no cupcake":
        - When the nominated student enters the laborinth, if there is a cupcake, he eats it and then increases the count. When the count becomes (NumberofStudents - 1), then he can declare to the minotaur that all the students have gone at least 1 time.
        - if there is no cupcake then he does nothing.

        - if any other student except the nominated one enters the room sees that there is no cupcake for <strong>THE FIRST TIME</strong>, he will order one from the servant and leave, else he does nothing and goes out.

    - Case 2 "We dont know nothing about the cupcake":
        -The nominated student enters the laborinth and sees that there is a cupcake, if it is then eat it and increase the count. if the count has become (2 * (NumberofStudents - 1)) he will declare to the minotaur that all the students have visited the laborinth. Else he does nothing
        
        -If any other student expect the nominated one enters the laborinth and sees for the <strong> second time <strong> that there is no cupcake, he will order one from the servant and eat it, else he just leaves.
    
</p>