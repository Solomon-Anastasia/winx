import tkinter as tk
from tkinter import ttk, messagebox, Menu
import json
import os

# --- File to store employee data ---
file_name = "employees.json"


# --- Function to save data ---
def save_data(company_var, department_var, name_var, day_var, month_var, year_var, position_var, salary_var):
    employee = {
        "companie": company_var.get(),
        "departament": department_var.get(),
        "nume": name_var.get(),
        "data_nastere": f"{day_var.get()} {month_var.get()} {year_var.get()}",
        "functie": position_var.get(),
        "salariu": salary_var.get()
    }

    # Load existing data
    if os.path.exists(file_name):
        with open(file_name, "r") as f:
            data = json.load(f)
    else:
        data = []

    data.append(employee)

    with open(file_name, "w") as f:
        json.dump(data, f, indent=4)

    messagebox.showinfo("Saved", "Employee data saved successfully!")


# --- Function to display all employees ---
def show_all_employees():
    if not os.path.exists(file_name):
        messagebox.showinfo("No data", "No employees saved yet.")
        return

    with open(file_name, "r") as f:
        data = json.load(f)

    # New window
    win = tk.Toplevel()
    win.title("All Employees")

    text = tk.Text(win, width=80, height=20)
    text.pack(padx=10, pady=10)

    if data:
        for emp in data:
            emp_info = (f"Companie: {emp['companie']}\n"
                        f"Departament: {emp['departament']}\n"
                        f"Nume: {emp['nume']}\n"
                        f"Data nastere: {emp['data_nastere']}\n"
                        f"Functie: {emp['functie']}\n"
                        f"Salariu: {emp['salariu']}\n"
                        f"{'-' * 50}\n")
            text.insert(tk.END, emp_info)
    else:
        text.insert(tk.END, "No employees saved yet.")


# --- Main function ---
def main():
    root = tk.Tk()
    root.title("Employee Entry")

    # --- Menu ---
    menu_bar = Menu(root)
    file_menu = Menu(menu_bar, tearoff=0)
    menu_bar.add_cascade(label="File", menu=file_menu)
    root.config(menu=menu_bar)

    # --- Variables ---
    company_var = tk.StringVar()
    department_var = tk.StringVar()
    name_var = tk.StringVar()
    position_var = tk.StringVar()
    salary_var = tk.StringVar()
    day_var = tk.StringVar()
    month_var = tk.StringVar()
    year_var = tk.StringVar()

    # --- Grid padding ---
    pad_y = 10
    pad_x = 5

    # --- Labels and entries ---
    tk.Label(root, text="Companie:").grid(row=0, column=0, sticky="e", padx=pad_x, pady=pad_y)
    tk.Entry(root, textvariable=company_var, width=30).grid(row=0, column=1, padx=pad_x, pady=pad_y)

    tk.Label(root, text="Departament:").grid(row=1, column=0, sticky="e", padx=pad_x, pady=pad_y)
    tk.Entry(root, textvariable=department_var, width=30).grid(row=1, column=1, padx=pad_x, pady=pad_y)

    tk.Label(root, text="Nume:").grid(row=2, column=0, sticky="e", padx=pad_x, pady=pad_y)
    tk.Entry(root, textvariable=name_var, width=30).grid(row=2, column=1, padx=pad_x, pady=pad_y)

    tk.Label(root, text="Data de nastere:").grid(row=3, column=0, sticky="e", padx=pad_x, pady=pad_y)

    frame_dob = tk.Frame(root)
    frame_dob.grid(row=3, column=1, padx=pad_x, pady=pad_y, sticky="w")

    # Day entry
    tk.Entry(frame_dob, textvariable=day_var, width=5).pack(side="left", padx=(0, 5))
    day_var.set("1")

    # Month combobox
    month_cb = ttk.Combobox(frame_dob, textvariable=month_var, width=10,
                            values=["Ianuarie", "Februarie", "Martie", "Aprilie", "Mai", "Iunie",
                                    "Iulie", "August", "Septembrie", "Octombrie", "Noiembrie", "Decembrie"])
    month_cb.pack(side="left", padx=(0, 5))
    month_cb.current(0)

    # Year entry
    tk.Entry(frame_dob, textvariable=year_var, width=7).pack(side="left")
    year_var.set("2000")

    tk.Label(root, text="Functie:").grid(row=4, column=0, sticky="e", padx=pad_x, pady=pad_y)
    tk.Entry(root, textvariable=position_var, width=30).grid(row=4, column=1, padx=pad_x, pady=pad_y)

    tk.Label(root, text="Salariu:").grid(row=5, column=0, sticky="e", padx=pad_x, pady=pad_y)
    tk.Entry(root, textvariable=salary_var, width=30).grid(row=5, column=1, padx=pad_x, pady=pad_y)

    # --- Menu commands ---
    file_menu.add_command(label="Save", command=lambda: save_data(
        company_var, department_var, name_var, day_var, month_var, year_var, position_var, salary_var))
    file_menu.add_command(label="Show All", command=show_all_employees)
    file_menu.add_separator()
    file_menu.add_command(label="Exit", command=root.quit)

    # --- Save Button ---
    tk.Button(root, text="Save", width=20, command=lambda: save_data(
        company_var, department_var, name_var, day_var, month_var, year_var, position_var, salary_var)).grid(
        row=6, column=0, columnspan=2, pady=pad_y + 5)

    root.mainloop()


# --- Run main ---
if __name__ == "__main__":
    main()
