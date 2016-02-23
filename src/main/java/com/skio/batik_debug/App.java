package com.skio.batik_debug;


import java.awt.Dimension;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.imageio.ImageIO;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
//    	Set Up Graphics
        DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
        Document doc = domImpl.createDocument("http://www.w3.org/2000/svg", "svg", null);
        SVGGeneratorContext context = SVGGeneratorContext.createDefault(doc);
        SVGGraphics2D graphics = new SVGGraphics2D(context, false);
        graphics.setSVGCanvasSize(new Dimension(800, 600));
        
//      Load Image
        File imgFile = new File("tmp/test_jpeg.jpg");
        BufferedImage img = ImageIO.read(imgFile);
        
//      Create AffineTransform
        AffineTransform at = new AffineTransform(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
        
//      Draw Image
        graphics.drawRenderedImage(img, at);
        
//      Export SVG
        OutputStreamWriter svgWriter = new FileWriter("tmp/test_output.svg");
        graphics.stream(svgWriter);
        
    }
}
