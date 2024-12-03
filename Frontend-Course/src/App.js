import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Home from './Home'
import Edit from './Edit'
import AddCourse from './AddCourse'


const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/edit-course/:id" element={<Edit />} />
        <Route path="/add-course" element={<AddCourse />} />
      </Routes>


    </BrowserRouter>
  )
}

export default App