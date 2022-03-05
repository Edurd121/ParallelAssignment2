# ParallelAssignment2
<strong> Assignment repo for Dr. Dechev Parallel Programming Class </strong>
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
        - The nominated student enters the laborinth and sees that there is a cupcake, if it is then eat it and increase the count. if the count has become (2 * (NumberofStudents - 1)) he will declare to the minotaur that all the students have visited the laborinth. Else he does nothing
        
        - If any other student expect the nominated one enters the laborinth and sees for the <strong> second time <strong> that there is no cupcake, he will order one from the servant and eat it, else he just leaves.

Even though this might not be the most efficient/fastest way of checking if all the students have gone through the laborinth, its a safe way of knowing they did.

</p>

<hr/>
 
<p>
For Part (2), we have 3 options to choose for to implement as our strategy/protocol where each guest is represented by 1 running thread and the minotaur is allowing us to see the crystal vase on the showroom:

   - 1. For our First strategy, we have that a guest could stop by and check whether the showroom was open and try to enter it. This allows the guests to roam around the place but also places some stress on the door as many people would like to peek in and check if it was open (In terms of a queue line). If some person wanted to see the vase, he/she will not have any guarantee when it will be available. 

        - To me this seems like a brute force type of strategy. We are putting guests on large crowds trying to have a chance to peek the door to see if they have a chance, this would not be the most efficient way since there could be other types of ways to announce to the crowds when it is available or not to enter. 

        - Since every guest is eager to see the vase, it makes sense that making other ways of making their lives easier would be a better choice overall instead of choosing to make them choose.

        - This also makes it harder for guests to actually have a chance at peeking inside because since there is a large crowd of people waiting to peek inside, once they try to peek and see its not available they'd have to join a queue of people to randomly have a chance of actually peeking. 
    
   - 2. Our second strategy, we have that the guests are allowed to place a sign on the door to indicate if the room is available. This would have an AVAILABLE and BUSY name. We have that our guests are responsible of setting this sign to its appropriate place. When entering the room the guest entering is resposible of setting the sign to BUSY and back to AVAILABLE when exiting. 

        - Doing this we ensure that the guests will not bother to "PEEK" onto the showroom to see if its busy in the first place. This in the first place seems like a great improvement over the first strategy since we are getting rid of that extra layer of complexity for our guests.

        - One thing that makes it a little complex in its own way which could be a dissadvantage is the setting of the sign. Since we have that the person going in has to set the sign to "BUSY" or "AVAILABLE", it adds a bit more time to change it but it allows for a clean way of dispersing the crowding at the door since there is something already telling them its available or not. 

    - 3. Our Third Strategy, we have that the guests are allowed to line in a queue. At the end, when the guest is exiting the room, it "HAS" to notify the guest standing in front of the queue that the room is available. This also allows for queueing multiple times.

        - While short, this creates a very simple way of allowing the guests to actually have a chance of seeing the room. This unlucky other strategies, takes much of the randomness since a guest just has to wait its turn to enter the room.

        - On the other hand. If you finally got your chance of seeing the room and head out but want to go again, you'd have to make you wait all over again. In other strategies it might be nicer to have this ammount of randomness in place since you have chance of actually entering before you peers if you get lucky in their own strategies.

        - While being the strategy of making sure every guest gets to see the vase at least once, it doesn't make for an efficient algorithm that implements some sort of idea to help the guests with their time. 

In short, I believe that the <Strong> second strategy </Strong> is the best choice. This involves the randomness involved of being able to peek randomly and have a chance of getting in before your peers if you're lucky and also the de-stressing on the door to be able to enter. This makes it a clear choice between the other two, since it has a more robust algorithm that doesnt brute force it all the way but also doesn't just implement a simple queue algorithm and calls it a day.


</p>