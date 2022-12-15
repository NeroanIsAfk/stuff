namespace Laboratoire___2
{
    public static class ForumUtils
    {
        public static string[] FORBIDDEN_LOGINS = new[] { "fart", "nword" , ""};

        public static bool ValidLogin(string loginUser)
        {
            bool isLoginCorrect = true;

            foreach (string badLogin in FORBIDDEN_LOGINS)
            {
                if (badLogin == loginUser.ToLower())
                {
                    isLoginCorrect = false;
                }
            }
            return isLoginCorrect;
        }
        
        public static int Encode(string passwordUser)
        {
            int sumPassword = 0;

            foreach (char caracter in passwordUser)
            {
                sumPassword += caracter;
            }
            return sumPassword % 997;
        }

        public static int SpaceCount(string text)
        {
            int nbSpaces = 0;
            
            foreach (char caracter in text)
            {
                if (char.IsWhiteSpace(caracter))
                {
                    nbSpaces++;
                }
            }

            return nbSpaces;
        }

        public static int DigitCount(string text)
        {
            int nbDigits = 0;

            foreach (char caracter in text)
            {
                if (char.IsDigit(caracter))
                {
                    nbDigits++;
                }
            }

            return nbDigits;
        }

        public static void Count(string text, out int spaceCount, out int digitCount)
        {
            spaceCount = 0;
            digitCount = 0;

            foreach (char caracter in text)
            {
                if (char.IsWhiteSpace(caracter))
                {
                    spaceCount++;
                }

                if (char.IsDigit(caracter))
                {
                    digitCount++;
                }
            }
        }

        public static void CountAndUpdate(string text, ref int spaceCount, ref int digitCount)
        {
            foreach (char caracter in text)
            {
                if (char.IsWhiteSpace(caracter))
                {
                    spaceCount++;
                }

                if (char.IsDigit(caracter))
                {
                    digitCount++;
                }
            }
        }
    }
}