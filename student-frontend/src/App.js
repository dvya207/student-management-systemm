import React, { useState, useEffect } from "react";
import axios from "axios";
import "./App.css";

function App() {

  const [students, setStudents] = useState([]);

  const [student, setStudent] = useState({
    name: "",
    email: "",
    gradeLevel: ""
  });

  const [selectedStudent, setSelectedStudent] = useState(null);
  const [editMode, setEditMode] = useState(false);
  const [editId, setEditId] = useState(null);

  useEffect(() => {
    fetchStudents();
  }, []);

  const fetchStudents = async () => {
    try {

      const response = await axios.get(
        "http://localhost:8080/api/students"
      );

      setStudents(response.data);

    } catch (error) {
      console.log(error);
    }
  };

  const handleChange = (e) => {

    setStudent({
      ...student,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {

    e.preventDefault();

    try {

      if (editMode) {

        await axios.put(
          `http://localhost:8080/api/students/${editId}`,
          student
        );

        alert("Student Updated Successfully");

        setEditMode(false);
        setEditId(null);

      } else {

        await axios.post(
          "http://localhost:8080/api/students",
          student
        );

        alert("Student Added Successfully");
      }

      setStudent({
        name: "",
        email: "",
        gradeLevel: ""
      });

      fetchStudents();

    } catch (error) {
      console.log(error);
    }
  };

  const viewStudent = (student) => {
    setSelectedStudent(student);
  };

  const editStudent = (student) => {

    setStudent({
      name: student.name,
      email: student.email,
      gradeLevel: student.gradeLevel
    });

    setEditMode(true);
    setEditId(student.id);
  };

  const deleteStudent = async (id) => {

    if (!window.confirm("Delete Student?"))
      return;

    try {

      await axios.delete(
        `http://localhost:8080/api/students/${id}`
      );

      alert("Student Deleted");

      fetchStudents();

    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div className="container">

      <div className="form-container">

        <h1 className="title">
          Student Management System
        </h1>

        <form onSubmit={handleSubmit}>

          <div className="input-group">
            <label>Student Name</label>

            <input
              type="text"
              name="name"
              value={student.name}
              onChange={handleChange}
              required
            />
          </div>

          <div className="input-group">
            <label>Email</label>

            <input
              type="email"
              name="email"
              value={student.email}
              onChange={handleChange}
              required
            />
          </div>

          <div className="input-group">
            <label>Grade Level</label>

            <input
              type="text"
              name="gradeLevel"
              value={student.gradeLevel}
              onChange={handleChange}
              required
            />
          </div>

          <button
            type="submit"
            className="add-btn"
          >
            {editMode ? "Update Student" : "Add Student"}
          </button>

        </form>

      </div>

      <div className="table-section">

        <h2>Student Records</h2>

        <table>

          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Grade Level</th>
              <th>Actions</th>
            </tr>
          </thead>

          <tbody>

            {students.map((s) => (

              <tr key={s.id}>

                <td>{s.id}</td>
                <td>{s.name}</td>
                <td>{s.email}</td>
                <td>{s.gradeLevel}</td>

                <td>

                  <button
                    className="view-btn"
                    onClick={() => viewStudent(s)}
                  >
                    View
                  </button>

                  <button
                    className="edit-btn"
                    onClick={() => editStudent(s)}
                  >
                    Edit
                  </button>

                  <button
                    className="delete-btn"
                    onClick={() => deleteStudent(s.id)}
                  >
                    Delete
                  </button>

                </td>

              </tr>

            ))}

          </tbody>

        </table>

      </div>

      {selectedStudent && (

        <div className="view-card">

          <h2>Student Details</h2>

          <p>
            <strong>ID:</strong> {selectedStudent.id}
          </p>

          <p>
            <strong>Name:</strong> {selectedStudent.name}
          </p>

          <p>
            <strong>Email:</strong> {selectedStudent.email}
          </p>

          <p>
            <strong>Grade Level:</strong> {selectedStudent.gradeLevel}
          </p>

        </div>

      )}

    </div>
  );
}

export default App;