import os
from reportlab.lib.pagesizes import letter
from reportlab.lib import colors
from reportlab.lib.styles import getSampleStyleSheet
from reportlab.platypus import Paragraph, Spacer
from reportlab.pdfgen import canvas
from reportlab.lib.units import inch  # Import the inch unit from the units module
from PIL import Image as PILImage

def txt_to_pdf_with_image(input_file, image_file, output_file):
    # Get the absolute path of the input files and the output folder
    input_file = os.path.abspath(input_file)
    image_file = os.path.abspath(image_file)
    output_folder = os.path.dirname(input_file)

    # Read the text content from the input file
    with open(input_file, 'r') as file:
        text_content = file.read()

    # Load the image and resize if needed
    max_image_width = 250  # Adjust this value as needed
    max_image_height = 200  # Adjust this value as needed
    image = PILImage.open(image_file)
    image_width, image_height = image.size

    if image_width > max_image_width or image_height > max_image_height:
        image.thumbnail((max_image_width, max_image_height))

    # Create a PDF document
    c = canvas.Canvas(os.path.join(output_folder, output_file), pagesize=letter)

    # Split the text content into paragraphs and draw it on the canvas
    styles = getSampleStyleSheet()
    paragraph_style = styles['Normal']
    y = letter[1] - 0.75 * inch  # Set the initial y position for drawing text

    paragraphs = text_content.split('\n')
    for paragraph in paragraphs:
        p = Paragraph(paragraph, paragraph_style)
        p.wrapOn(c, 8*inch, 18*inch)  # Set the width and height of the text box
        p.drawOn(c, 1*inch, y)  # Draw the text at the specified position
        y -= p.height + 0.1 * inch  # Update the y position for the next paragraph

    # Draw the image on the same page
    x_offset = letter[0] - image.width - 1 * inch
    y_offset = letter[1] - image.height - 0.5 * inch
    c.drawImage(image_file, x_offset, y_offset, width=image.width, height=image.height)

    # Save the PDF document
    c.save()

if __name__ == "__main__":
    input_file = input("Enter the path to the input .txt file: ")
    image_file = input("Enter the path to the image file: ")

    # Check if the input files exist
    if not os.path.exists(input_file):
        print(f"The input file '{input_file}' does not exist.")
    elif not os.path.exists(image_file):
        print(f"The image file '{image_file}' does not exist.")
    else:
        # Get the filename without the extension as the output filename
        output_file = os.path.splitext(os.path.basename(input_file))[0] + ".pdf"
        txt_to_pdf_with_image(input_file, image_file, output_file)
        print(f"PDF generated and saved as '{output_file}' in the same folder as the input files.")
