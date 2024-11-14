from tkinter import *
import random
import pyperclip

# Initialize the Tkinter window
root = Tk()
root.geometry("800x500")
root.title("Enhanced Password Generator")

# Variables
passwrd = StringVar()
passlen = IntVar()
passlen.set(8)  # Set a default length for the password
include_special = BooleanVar()
include_numbers = BooleanVar()
include_uppercase = BooleanVar()


# Function to generate the password
def generate():
    characters = list('abcdefghijklmnopqrstuvwxyz')

    # Add character sets based on user preferences
    if include_uppercase.get():
        characters.extend('ABCDEFGHIJKLMNOPQRSTUVWXYZ')
    if include_numbers.get():
        characters.extend('0123456789')
    if include_special.get():
        characters.extend('!@#$%^&*()')

    # Generate the password
    password = ''.join(random.choice(characters) for _ in range(passlen.get()))
    passwrd.set(password)


# Function to copy the password to clipboard
def copyclipboard():
    pyperclip.copy(passwrd.get())


# Main title label
Label(root, text="Advanced Password Generator", font="Courier 24 bold", fg="#3b5998").pack(pady=10)

# Frame for options
frame_options = Frame(root)
frame_options.pack(pady=10)

# Label for password length and entry
Label(frame_options, text="Password Length:", font="Courier 14").grid(row=0, column=0, padx=10, pady=5)
Entry(frame_options, textvariable=passlen, width=5, font="Courier 14").grid(row=0, column=1, pady=5)

# Checkbuttons for character options
Checkbutton(frame_options, text="Include Uppercase Letters", variable=include_uppercase, font="Courier 12").grid(row=1,
                                                                                                                 column=0,
                                                                                                                 sticky='w',
                                                                                                                 pady=5)
Checkbutton(frame_options, text="Include Numbers", variable=include_numbers, font="Courier 12").grid(row=2, column=0,
                                                                                                     sticky='w', pady=5)
Checkbutton(frame_options, text="Include Special Characters", variable=include_special, font="Courier 12").grid(row=3,
                                                                                                                column=0,
                                                                                                                sticky='w',
                                                                                                                pady=5)

# Generate button
Button(root, text="Generate Password", font="Courier 14 bold", command=generate, bg="#4CAF50", fg="white").pack(pady=10)

# Entry to display the generated password
Label(root, text="Generated Password:", font="Courier 14").pack(pady=5)
Entry(root, textvariable=passwrd, font="Courier 14", width=30).pack(pady=5)

# Copy to clipboard button
Button(root, text="Copy to Clipboard", font="Courier 14", command=copyclipboard, bg="#2196F3", fg="white").pack(pady=10)

# Footer for additional information or credits
Label(root, text="Enhanced GUI for Password Generator", font="Courier 10 italic", fg="grey").pack(side="bottom",
                                                                                                  pady=10)

# Run the main loop
root.mainloop()