using System;

namespace Laboratoire___2
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            /*User user1 = new User("Neroan", "Li242-asc23", new DateTime(2008,7,12));
            
            user1.AddPost();
            user1.AddPost();
            
            Console.WriteLine(user1);*/

            void AssertBool(string test, bool expected, bool observed)
            {
                Console.WriteLine("Test: " + test); 
                Console.WriteLine("Expected: " + expected + ", observed: " + observed); 
                Console.WriteLine(expected == observed ? "Ok!" : "KO !!!"); 
                Console.WriteLine();
            }

            void TestValidLogin()
            {
                AssertBool("Herbert", true, ForumUtils.ValidLogin("Herbert")); 
                AssertBool("empty string", false, ForumUtils.ValidLogin("")); 
                AssertBool("fart", false, ForumUtils.ValidLogin("fart")); 
                AssertBool("FART", false, ForumUtils.ValidLogin("FART")); 
                AssertBool("FaRt", false, ForumUtils.ValidLogin("FaRt"));
            }
            User m = new User("Cunégonde", "motdepasse");
            /*User u1 = new User("Prout", "Check");
            User u2 = new User("Rout", "Heck");
            User u3 = new User("Out", "Eck");
            User u4 = new User("Ut", "Heck");
            Post p = new Post("XD", "Blablabla", DateTime.Today);
            p.AddLike(u1, u2, u3, u4);
            Console.WriteLine(p.ToString()); ALT + MAJ + A*/
            User u = new User("Mélusine", "12345"); 
            // 0 post, 0 space, 0 digit
            Post p1 = new Post(u, "Un deux trois");
            u.AddPost(p1);
            Console.WriteLine(u.PostCount);
            // 1 post, 2 spaces, 0 digit
            Post p2 = new Post(u, "456");
            u.AddPost(p2);
            Console.WriteLine(u.PostCount);
            // 2 posts, 2 spaces, 3 digits
        }
    }
}