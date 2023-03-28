package com.sproutframework.core.io;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.Iterator;

/**
 * 类路径下 xml 资源，包括了对其加载 & 解析
 * @author gaoweilin
 * @date 2023/03/27 Mon 10:59 PM
 */
public class ClassPathXmlResource implements Resource, Iterator<Element> {
    /** xml 文件资源 */
    private Document document;
    /** xml 根元素 */
    private Element rootDocument;
    /** xml 子元素迭代器 */
    private Iterator<Element> elementIterator;

    public ClassPathXmlResource(String fileName) {
        SAXReader saxReader = new SAXReader();
        URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
        try {
            this.document = saxReader.read(xmlPath);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        this.rootDocument = this.document.getRootElement();
        this.elementIterator = this.rootDocument.elementIterator();
    }

    @Override
    public boolean hasNext() {
        return this.elementIterator.hasNext();
    }

    @Override
    public Element next() {
        return this.elementIterator.next();
    }
}
