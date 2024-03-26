package com.example.seminar_test.controller;

import com.example.seminar_test.model.Lesson;
import com.example.seminar_test.model.TypeLesson;
import com.example.seminar_test.service.ILessonService;
import com.example.seminar_test.service.ILessonTypeService;
import com.example.seminar_test.service.LessonService;
import com.example.seminar_test.service.TypeLessonService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LessonServlet", value = "/lesson")
public class LessonServlet extends HttpServlet {
    private  static final ILessonService lessonService = new LessonService();
    private static final ILessonTypeService lessonTypeService = new TypeLessonService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }switch (action){
            case "showFormCreate":
                showFormCreate(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
            List<TypeLesson> typeLessons = lessonTypeService.getAll();
            request.setAttribute("typeLessons",typeLessons);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/form_create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Lesson> lessonList = lessonService.getAll();
        request.setAttribute("lessonList",lessonList);
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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
            create(request,response);
            break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String typeLessonName = request.getParameter("typeLesson");
        TypeLesson typeLesson = lessonTypeService.findByName(typeLessonName);
        String level = request.getParameter("level");
        int module = Integer.parseInt(request.getParameter("module"));
        String link = request.getParameter("link");
        Lesson lesson = new Lesson(name,typeLesson,level,module,link);
        lessonService.insert(lesson);
        try {
            response.sendRedirect("/lesson");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}