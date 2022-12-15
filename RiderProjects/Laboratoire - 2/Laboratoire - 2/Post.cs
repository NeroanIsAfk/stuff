using System;
using System.Runtime.CompilerServices;
using System.Text;

namespace Laboratoire___2
{
    public class Post
    {
        public const int INC_LIKEDBY_SIZE = 3;
        
        #region attributes
        private User author;
        private string contents;
        private DateTime date;
        private User[] likedBy = new User[INC_LIKEDBY_SIZE];
        #endregion
        
        #region constructor
        public Post(User author, string contents, DateTime date)
        {
            this.author = author;
            this.contents = contents;
            this.date = date;
        }

        public Post(User author, string contents) :
            this(author, contents, DateTime.Today) { }
        #endregion

        public string Contents
        {
            get
            {
                return contents;
            }
        }

        public override string ToString()
        {
            StringBuilder output = new StringBuilder();
            output.Append(author + " : " + contents + " ( " + date + " )\n");

            foreach (User user in likedBy)
            {
                output.Append(user + "\n");
            }

            return output.ToString();
        }

        public void AddLike(User user)
        {
            int i = 0;

            while (likedBy[i] != null)
            {
                i++;
            }

            if (i == likedBy.Length - 1)
            {
                User[] newLikedBy = new User[likedBy.Length + INC_LIKEDBY_SIZE];
                Array.Copy(likedBy, newLikedBy, likedBy.Length);
                likedBy = newLikedBy;
            }
            
            likedBy[i] = user;
        }

        public void AddLike(params User[] userList)
        {
            foreach (User user in userList)
            {
                AddLike(user);
            }
        }
    }
}