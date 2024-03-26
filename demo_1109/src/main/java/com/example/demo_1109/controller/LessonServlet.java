package com.example.demo_1109.controller;

import com.example.demo_1109.model.Lesson;
import com.example.demo_1109.model.LessonDTO;
import com.example.demo_1109.model.TypeLesson;
import com.example.demo_1109.service.ILessonService;
import com.example.demo_1109.service.ITypeLessonService;
import com.example.demo_1109.service.LessonService;
import com.example.demo_1109.service.TypeLessonService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LessonServlet", value = "/lesson")
public class LessonServlet extends HttpServlet {
    private static final ILessonService lessonService = new LessonService();
    private static final ITypeLessonService typeLessonService = new TypeLessonService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action ==null){
            action ="";
        }
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        LessonDTO list = lessonService.searchId(id);
        request.setAttribute("list",list);
        List<TypeLesson> typeLessonList = typeLessonService.getAll();
        request.setAttribute("typeLessonList",typeLessonList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showFormEdit.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        List<TypeLesson> typeLessonList = typeLessonService.getAll();
        request.setAttribute("typeLessonList",typeLessonList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<LessonDTO> lessonDTOList = lessonService.getAll();
        request.setAttribute("lessonDTOList",lessonDTOList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "delete":
                delete(request,response);
                break;
            case "edit":
                edit(request,response);
                break;
            default:
                create(request,response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String nameLesson = request.getParameter("nameLesson");
        String typeLesson = request.getParameter("typeLesson");
        int typeId = typeLessonService.searchId(typeLesson);
        String level = request.getParameter("level");
        String link = request.getParameter("link");
        Lesson lesson = new Lesson(nameLesson,typeId,level,link);
        lessonService.edit(id,lesson);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showFormEdit.jsp");
        request.setAttribute("message","Edit successful");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        lessonService.delete(id);
        try {
            response.sendRedirect("lesson");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String typeLesson = request.getParameter("typeLesson");
        int idType = typeLessonService.searchId(typeLesson);
        String level = request.getParameter("level");
        String link = request.getParameter("link");
        Lesson lesson = new Lesson(name,idType,level,link);
        lessonService.add(lesson);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create.jsp");
        request.setAttribute("message","Add successful");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}