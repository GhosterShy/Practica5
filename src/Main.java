interface IDocument{
    public void open();
}


class Report implements IDocument
{
    @Override
    public void open() {
        System.out.println("Report open!");
    }
}


class Resume implements IDocument
{

    @Override
    public void open() {
        System.out.println("Resume open");
    }
}


class Letter implements IDocument
{

    @Override
    public void open() {
        System.out.println("Letter open!");
    }
}




interface DocumentCreater
{
    IDocument createDocument();
}


class  ReportCreator implements DocumentCreater
{

    @Override
    public IDocument createDocument() {
        return  new Report();
    }
}


class ResumeCreator implements DocumentCreater
{

    @Override
    public IDocument createDocument() {
        return new Resume();
    }
}

class LetterCreator implements DocumentCreater
{

    @Override
    public IDocument createDocument() {
        return new Letter();
    }
}


enum Doctype
{
    Report,Resume,Letter
}

class Programm
{
    public IDocument Getdocument(Doctype type)
    {
        DocumentCreater creater = null;
        IDocument document = null;


        creater = switch (type) {
            case Doctype.Report -> new ReportCreator();
            case Doctype.Resume -> new ResumeCreator();
            case Doctype.Letter -> new LetterCreator();
        };
        document = creater.createDocument();
        return document;
    }

}




//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Programm programm = new Programm();
    programm.Getdocument(Doctype.Report).open();
    programm.Getdocument(Doctype.Resume).open();



    }
}