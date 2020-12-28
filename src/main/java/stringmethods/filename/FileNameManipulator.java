package stringmethods.filename;

public class FileNameManipulator {


    public boolean isItLegal(String what) {
        if (what.isBlank()) {
            return false;
        }
        return true;
    }

    public char findLastCharacter(String str) {
        if (isItLegal(str) == false) {
            throw new IllegalArgumentException("Empty string!");
        }
        return str.charAt(str.length() - 1);
    }

    public String findFileExtension(String fileName) {
        if (isItLegal(fileName) == false || !fileName.contains(".")) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        int dotPLace = 0;
        for (int i = 0; i < fileName.length(); i++)
            if (".".equals(fileName.charAt(i))) {
                dotPLace = i;
            }
        return fileName.substring(dotPLace);
    }

    public boolean compareFilesByName(String SearchedFileName, String actualFileName) {
        if (isItLegal(SearchedFileName) == false || isItLegal(actualFileName) == false) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        return SearchedFileName.equals(actualFileName);

    }

    public String changeExtensionToLowerCase(String fileName) {
        if (isItLegal(fileName) == false || !fileName.contains(".")) {
            throw new IllegalArgumentException("Invalid file name!");

        }
        int dotPLace = 0;
        for (int i = 0; i < fileName.length(); i++)
            if (".".equals(fileName.charAt(i))) {
                dotPLace = i;
            }
        String finished = fileName.substring(0, dotPLace) + fileName.substring(dotPLace + 1).toLowerCase();
        return finished;

    }

    public String replaceStringPart(String fileName, String present, String target){
       return fileName.replace(present,target);
    }
}





