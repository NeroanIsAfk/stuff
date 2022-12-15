namespace Laboratoire___3
{
    public class Emission
    {
        #region attributes
        protected string titre;
        protected int durée;
        #endregion
        
        #region constructor
        public Emission(string titre, int durée)
        {
            this.titre = titre;
            this.durée = durée;
        }
        #endregion

        public virtual string Présentation()
        {
            return titre + " ( " + durée + " minutes )";
        }
    }
}