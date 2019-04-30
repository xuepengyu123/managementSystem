package com.sys.manage.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * pdf功能实现
 * 1.创建一个简单的pdf文件
 * 2.给PDF文件设置文件属性
 * 3.PDF中添加图片
 * 4.PDF中创建表格
 * 5.PDF中创建列表
 * 6.PDF中设置样式/格式化输出，输出中文内容
 * 7.给PDF文件设置密码
 * 8.给PDF文件设置权限
 * 9.读取/修改已有的PDF文件
 *
 * 详细浏览
 * https://blog.csdn.net/luckykapok918/article/details/73088978
 */
public class PdfDemo {

    /**
     * 生成pdf文件路径
     */
    private static final String PDF_DIR = "E:/file/";
    /**
     * 图片
     */
    private static final String IMAGE_DIR = "E:/file/adminlogo.gif";

    /**
     * 创建一个简单的pdf文件
     *
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    @Test
    public void generatePdfText() throws FileNotFoundException, DocumentException {

        // 1.新建document对象
        Document document = new Document();
        String pdfDir = PDF_DIR + "generatePdfText.pdf";

        // 2.建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中。
        // 创建 PdfWriter 对象 第一个参数是对文档对象的引用，第二个参数是文件的实际名称，在该名称中还会给出其输出路径。
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfDir));

        // 3.打开文档
        document.open();

        // 4.添加一个内容段落
        document.add(new Paragraph("Hello World!"));

        // 5.关闭文档
        document.close();

    }

    /**
     * 给PDF文件设置文件属性
     *
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    @Test
    public void generatePdfProperty() throws FileNotFoundException, DocumentException {

        //创建文件
        Document document = new Document();
        String pdfDir = PDF_DIR + "generatePdfProperty.pdf";

        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfDir));
        //打开文件
        //添加内容
        document.add(new Paragraph("Some content here"));

        //设置属性
        //标题
        document.addTitle("this is a title");
        document.open();
        //作者
        document.addAuthor("H__D");
        //主题
        document.addSubject("this is subject");
        //关键字
        document.addKeywords("Keywords");
        //创建时间
        document.addCreationDate();
        //应用程序
        document.addCreator("hd.com");

        //关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }

    /**
     * PDF中添加图片
     *
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    @Test
    public void generatePdfImage() throws IOException, DocumentException {
        //创建文件
        Document document = new Document();
        String pdfDir = PDF_DIR + "generatePdfImage.pdf";
        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfDir));
        //打开文件
        document.open();
        //添加内容
        document.add(new Paragraph("HD content here"));

        //图片1
        Image image1 = Image.getInstance(IMAGE_DIR);
        //设置图片位置的x轴和y周
        image1.setAbsolutePosition(100f, 550f);
        //设置图片的宽度和高度
        image1.scaleAbsolute(200, 200);
        //将图片1添加到pdf文件中
        document.add(image1);

        //图片2
        Image image2 = Image.getInstance(IMAGE_DIR);
        //将图片2添加到pdf文件中
        document.add(image2);

        //关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }

    /**
     * PDF中创建表格
     *
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    @Test
    public void generatePdfForm() throws FileNotFoundException, DocumentException {
        //创建文件
        Document document = new Document();
        String pdfDir = PDF_DIR + "generatePdfForm.pdf";
        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfDir));
        //打开文件
        document.open();
        //添加内容
        document.add(new Paragraph("HD content here"));

        // 3列的表.
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100); // 宽度100%填充
        table.setSpacingBefore(10f); // 前间距
        table.setSpacingAfter(10f); // 后间距
        // 与下边的list方法冲突，手动引入
        java.util.List<PdfPRow> listRow = table.getRows();
        //设置列宽
        float[] columnWidths = {1f, 2f, 3f};
        table.setWidths(columnWidths);

        //行1
        PdfPCell cells1[] = new PdfPCell[3];
        PdfPRow row1 = new PdfPRow(cells1);

        //单元格
        cells1[0] = new PdfPCell(new Paragraph("111"));//单元格内容
        cells1[0].setBorderColor(BaseColor.BLUE);//边框验证
        cells1[0].setPaddingLeft(20);//左填充20
        cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
        cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

        cells1[1] = new PdfPCell(new Paragraph("222"));
        cells1[2] = new PdfPCell(new Paragraph("333"));

        //行2
        PdfPCell cells2[] = new PdfPCell[3];
        PdfPRow row2 = new PdfPRow(cells2);
        cells2[0] = new PdfPCell(new Paragraph("444"));

        //把第一行添加到集合
        listRow.add(row1);
        listRow.add(row2);
        //把表格添加到文件中
        document.add(table);

        //关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }

    /**
     * PDF中创建列表
     *
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    @Test
    public void generatePdfList() throws FileNotFoundException, DocumentException {

        //创建文件
        Document document = new Document();
        String pdfDir = PDF_DIR + "generatePdfList.pdf";

        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfDir));
        //打开文件
        document.open();
        //添加内容
        document.add(new Paragraph("HD content here"));

        //添加有序列表
        List orderedList = new List(List.ORDERED);
        orderedList.add(new ListItem("Item one"));
        orderedList.add(new ListItem("Item two"));
        orderedList.add(new ListItem("Item three"));
        document.add(orderedList);

        //关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }


    /**
     * PDF中设置样式/格式化输出，输出中文内容，必须引入itext-asian.jar
     *
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    @Test
    public void generatePdfHanZi() throws IOException, DocumentException {
        //创建文件
        Document document = new Document();
        String pdfDir = PDF_DIR + "generatePdfHanZi.pdf";

        //建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfDir));
        //打开文件
        document.open();

        //中文字体,解决中文不能显示问题
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

        //蓝色字体
        Font blueFont = new Font(bfChinese);
        blueFont.setColor(BaseColor.BLUE);
        //段落文本
        Paragraph paragraphBlue = new Paragraph("paragraphOne blue front", blueFont);
        document.add(paragraphBlue);

        //绿色字体
        Font greenFont = new Font(bfChinese);
        greenFont.setColor(BaseColor.GREEN);
        //创建章节
        Paragraph chapterTitle = new Paragraph("段落标题xxxx", greenFont);
        Chapter chapter1 = new Chapter(chapterTitle, 1);
        chapter1.setNumberDepth(0);

        Paragraph sectionTitle = new Paragraph("部分标题", greenFont);
        Section section1 = chapter1.addSection(sectionTitle);

        Paragraph sectionContent = new Paragraph("部分内容", blueFont);
        section1.add(sectionContent);

        //将章节添加到文章中
        document.add(chapter1);

        //关闭文档
        document.close();
        //关闭书写器
        writer.close();
    }

    /**
     * 给PDF文件设置密码，需要引入bcprov-jdk15on.jar包：
     *
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    @Test
    public void generatePdfSetPassword() throws FileNotFoundException, DocumentException {
        // 创建文件
        Document document = new Document();
        String pdfDir = PDF_DIR + "generatePdfSetPassword.pdf";

        // 建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfDir));

        //用户密码
        String userPassword = "123456";
        //拥有者密码
        String ownerPassword = "hd";
        writer.setEncryption(userPassword.getBytes(), ownerPassword.getBytes(), PdfWriter.ALLOW_PRINTING,
                PdfWriter.ENCRYPTION_AES_128);

        // 打开文件
        document.open();

        //添加内容
        document.add(new Paragraph("password !!!!"));

        // 关闭文档
        document.close();
        // 关闭书写器
        writer.close();

    }

    /**
     * 给PDF文件设置权限
     *
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    @Test
    public void generatePdfSetPermissions() throws FileNotFoundException, DocumentException {
        // 创建文件
        Document document = new Document();
        String pdfDir = PDF_DIR + "generatePdfHanZi.pdf";

        // 建立一个书写器
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pdfDir));

        // 只读权限
        writer.setEncryption("".getBytes(), "".getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);

        // 打开文件
        document.open();

        // 添加内容
        document.add(new Paragraph("password !!!!"));

        // 关闭文档
        document.close();
        // 关闭书写器
        writer.close();
    }

    /**
     * 读取/修改已有的PDF文件
     *
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    @Test
    public void generatePdfModify() throws IOException, DocumentException {
        String pdfDir = PDF_DIR + "generatePdfHanZi.pdf";
        //读取pdf文件
        PdfReader pdfReader = new PdfReader(pdfDir);

        //修改器
        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("C:/Users/H__D/Desktop/test10.pdf"));

        Image image = Image.getInstance("C:/Users/H__D/Desktop/IMG_0109.JPG");
        image.scaleAbsolute(50, 50);
        image.setAbsolutePosition(0, 700);

        for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
            PdfContentByte content = pdfStamper.getUnderContent(i);
            content.addImage(image);
        }

        pdfStamper.close();

    }
}

