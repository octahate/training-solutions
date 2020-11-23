package stringmethods.filename;

public class FileNameManipulator {

    public void isItLegal (String what){
        if (what.isBlank()) {
            throw new IllegalArgumentException("Empty string!");
        } else
            if (!what.contains(".") && what.endsWith(".")){
                throw new IllegalArgumentException("Invalid argument!");
            }
    }

    public char findLastCharacter (String str) {
        isItLegal(str);
        return str.charAt(str.length()-1);
    }

    public String findFileExtension(String fileName) {
        isItLegal(fileName);
        int dotPLace = 0;
        for (int i = 0; i < fileName.length(); i++)
            if (".".equals(fileName.charAt(i))) {
                dotPLace = i;
        }
        return fileName.substring(dotPLace);
    }

    public boolean identifyFileExtension (String ext, String fileName){
       String ext2 =  findFileExtension(fileName);
       if (ext.equals(ext2)) {
           return true;}
       return false;
    }



}
