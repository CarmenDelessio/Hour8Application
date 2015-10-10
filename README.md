# Hour8Application
Hour 8 - Using ListViews

### Errata Hour 8
In the book LISTING 8.2  returns a view.  It should return a TextView

``` 
 20:     public View getView(int position, View convertView, ViewGroup parent) {
 21:       TextView textView = (TextView) mInflater.inflate( 
 22:                                      R.layout.text_view_item, null);
 23:       textView.setText(mPies[position]);
 24:       return view;
 25:     }
 26:  }  
```
 should be
```
 20:     public View getView(int position, View convertView, ViewGroup parent) {
 21:       TextView textView = (TextView) mInflater.inflate( 
 22:                                      R.layout.text_view_item, null);
 23:       textView.setText(mPies[position]);
 24:       return textView;
 25:     }
 26:  }  
 ```

