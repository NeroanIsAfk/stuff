using System;

namespace Laboratoire___1
{
    public class Map
    {
        #region attributes
        private string name;
        private int verticalSize;
        private int horizontalSive;
        private bool authorizedInCompetiton;
        #endregion
        
        #region constructors
        public Map(string name, int verticalSize, int horizontalSive, bool authorizedInCompetiton)
        {
            this.name = name;
            this.verticalSize = verticalSize;
            this.horizontalSive = horizontalSive;
            this.authorizedInCompetiton = authorizedInCompetiton;
        }

        public Map(string name, int verticalSize, int horizontalSive) :
            this(name, verticalSize, horizontalSive, true) { }

        public Map(string name, int verticalSize, bool authorizedInCompetiton) :
            this(name, verticalSize, verticalSize, authorizedInCompetiton) { }
        #endregion

        public string GetName()
        {
            return name;
        }

        public int Surface()
        {
            return horizontalSive * verticalSize;
        }

        public override string ToString()
        {
            return name + " (" + verticalSize + " X " + horizontalSive + ")";
        }

        public string Description()
        {
            string output = "";

            output += name + " (taille " + verticalSize + " X " + horizontalSive + ", surface " + Surface() +
                      " cases)\n";

            if (authorizedInCompetiton)
            {
                output += "Utilisable en compétition";
                Console.ForegroundColor = ConsoleColor.Blue;
            }
            else
            {
                output += "Pas utilisable en compétition";
                Console.ForegroundColor = ConsoleColor.Red;
            }

            return output;
        }
    }
}