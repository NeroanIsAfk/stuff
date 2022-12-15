using System;
using Microsoft.SqlServer.Server;

namespace Laboratoire___2
{
    public class User
    {
        #region attributes
        private string login;
        private int password;
        private DateTime joinDate;
        private int postCount;
        private int spacesPosted;
        private int digitsPosted;
        #endregion
        
        #region constructor
        public User(string login, string password, DateTime joinDate)
        {
            Login = login;
            Password = password;
            this.joinDate = joinDate;
            postCount = 0;
            spacesPosted = 0;
            digitsPosted = 0;
        }

        public User(string login, string password) :
            this(login, password, DateTime.Today) { }

        public User(string login, string password, int joinDate) :
            this(login, password)
        {
            JoinDate = joinDate;
        }
        
        #endregion

        public string Login
        {
            get
            {
                return login;
            }
            set
            {
                if (ForumUtils.ValidLogin(value))
                {
                    login = value;
                }
            }
        }

        public string Password
        {
            set
            {
                password = ForumUtils.Encode(value);
            }
        }
        
        public int JoinDate
        {
            get
            {
                return int.Parse(joinDate.ToString("yyyyMMdd"));
            }
            set
            {
                joinDate = new DateTime(value / 10_000, (value / 100) % 100, value % 100);
            }
        }

        public string PostCount
        {
            get
            {
                return postCount + " - " + spacesPosted + " : " + digitsPosted;
            }
        }

        public void AddPost(Post post)
        {
            // Intérêt de ref / out 
            // -> Permet de travailler directement sur l'adresse ( soit faire += ou autre )
            // -> Permet de travailler avec une valeur qui revient toujours à 0
            ForumUtils.CountAndUpdate(post.Contents, ref spacesPosted, ref digitsPosted);
            postCount++;
        }
        
        public bool ValidatePassword(string passwordUser)
        {
            return ForumUtils.Encode(passwordUser) == password;
        }

        public override string ToString()
        {
            return login + " (password: " + password + "), " + joinDate + " - " + postCount + (postCount > 1
                ? " posts"
                : " post");
        }
    }
}