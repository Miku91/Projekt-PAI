package com.example.egzamin.ui;

import com.example.egzamin.models.Users;
import com.example.egzamin.repository.LocationsRepository;
import com.example.egzamin.repository.UsersRepository;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteParameters;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

import java.io.IOException;

import static com.vaadin.flow.component.login.LoginI18n.*;

@Route("/ui/login")
public class UserLogin extends VerticalLayout {
    HorizontalLayout mainLayout = new HorizontalLayout();

    LoginForm loginForm = new LoginForm();
    LoginI18n idkCoTo = createDefault();

    public UserLogin(){
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);



        add(loginForm);
    }

    @Autowired
    UsersRepository usersRepository;


@PostConstruct
    private void init(){
    //mainLayout.add(loginForm);


    LoginFormConf();



   // mainLayout.add(loginForm);


    //add(mainLayout);
    }



    private void LoginFormConf(){
        Form form = idkCoTo.getForm();

        form.setTitle("Logowanie");
        form.setUsername("Nazwa użytkownika");
        form.setPassword("Hasło");
        form.setSubmit("Zaloguj");
        form.setForgotPassword("");
        idkCoTo.setForm(form);

        LoginI18n.ErrorMessage formErrorMessage = idkCoTo.getErrorMessage();
        formErrorMessage.setTitle("Niepoprawny login lub hasło");
        formErrorMessage.setMessage("Sprawdź czy wprowadziłeś poprawnie login i hasło");
        idkCoTo.setErrorMessage(formErrorMessage);

        loginForm.setError(false);

        loginForm.setI18n(idkCoTo);

        loginForm.addLoginListener(e -> {
            checkLogin(e.getUsername(), e.getPassword());
        });
        loginForm.setForgotPasswordButtonVisible(false);




    }
    boolean check = true;
    private void checkLogin(String login, String password){

        usersRepository.findAll().stream()
                .forEach(user -> {
                    try {
                        if(check)
                        {
                            if (user.getLogin().equals(login)) {
                                if(user.getPassword().equals(password)) {
                                    System.out.println("logged in "+ user.getLogin());
                                    //getUI().ifPresent(ui ->
                                            //ui.navigate("ui/menu"));
                                    getUI().ifPresent(ui -> ui.navigate(
                                                    MainUI.class,
                                                    new RouteParameters("userID", String.valueOf(user.getId()))));
                                    check = false;

                                     //return;
                                } else {
                                    System.out.println("wrong password");
                                    loginForm.setError(true);
                                    //System.out.println("dziala");
                                }
                            }else{
                                //System.out.println("error nie ma loginu lub hasla!");
                                //loginForm.setError(true);
                            }
                        }
                        } catch (Exception d) {
                        d.printStackTrace();
                    }
                });
        if(check)
        {
            System.out.println("error nie ma loginu lub hasla!");
            loginForm.setError(true);
        }
        //String login = idkCoTo.getForm().getUsername();
        //Users user = usersRepository.findByLogin(login);
        check = true;
    }



}
