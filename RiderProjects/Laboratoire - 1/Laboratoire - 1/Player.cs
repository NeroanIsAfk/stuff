using System;
using System.Text;

namespace Laboratoire___1
{
    public class Player
    {

        public const int NB_MAX_MAPS = 5;
        
        #region attributes
        private string lastName;
        private string firstName;
        private DateTime birthday;
        private int skillRating;
        private bool sponsored;
        private Map[] maps = new Map[NB_MAX_MAPS];
        #endregion

        #region constructors
        public Player(string lastName, string firstName, DateTime birthday, bool isRanked)
        {
            this.lastName = lastName;
            this.firstName = firstName;
            this.birthday = birthday;
            skillRating = isRanked ? 1 : 0;
        }

        public Player(string lastName, string firstName, DateTime birthday) :
            this(lastName, firstName, birthday, true) { } 
        #endregion
        
        public string GetName ()
        {
            return lastName + " " + firstName;
        }

        public string GetBirthday()
        {
            return birthday.Day + "/" + birthday.Month + "/" + birthday.Year;
        }

        private bool IsRanked()
        {
            return skillRating > 0;
        }

        public void SetRanked()
        {
            if (!IsRanked())
            {
                skillRating = 1;
            }
        }

        public override string ToString()
        {
            string output = "";
            
            output += "Nom et prénom : " + GetName() + "\n";
            output += "Date de naissance : " + GetBirthday() + "\n";
            output += IsRanked() ? "Compétiteur" : "Non compétiteur";

            return output;
        }

        public void ModifySkillRating (int points)
        {
            if (IsRanked())
            {
                skillRating += points;

                if (skillRating > 5000)
                {
                    skillRating = 5000;
                }

                if (skillRating < 1)
                {
                    skillRating = 1;
                }
            }
        }

        public void AddMap(Map map)
        {
            int iMap = 0;
            Map previousMap = map;

            do
            {
                Map currentMap = maps[iMap];
                maps[iMap] = previousMap;
                previousMap = currentMap;
                iMap++;
            } while (iMap < NB_MAX_MAPS && map != previousMap);
        }

        public string ListingMaps ()
        {
            StringBuilder output = new StringBuilder();
            int i = 1;

            foreach (Map map in maps)
            {
                if (map != null)
                {
                    output.Append(i + " - " + map.GetName() + "\n");
                    i++;   
                }
            }

            return output.ToString();
        }
    }
}