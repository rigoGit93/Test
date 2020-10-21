package nl.inholland.endassignment.controller;

import nl.inholland.endassignment.view.AddArticle;
import nl.inholland.endassignment.view.Views;

public class ArticleController extends Controllers{

    private AddArticle view;

    public ArticleController() {
        view = new AddArticle();
    }

    @Override
    public Views getView() {
        return view;
    }
}
