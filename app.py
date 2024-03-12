from sklearn.tree import DecisionTreeClassifier
from sklearn.model_selection import train_test_split
import csv,numpy as np,pandas as pd
import os
from flask import Flask,request,jsonify
app = Flask(__name__)
data = pd.read_csv(os.path.join("Training.csv"))
df = pd.DataFrame(data)
cols = df.columns
cols = cols[:-1]
x = df[cols]
y = df['prognosis']
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.33, random_state=42)
print ("DecisionTree")
dt = DecisionTreeClassifier()
clf_dt=dt.fit(x_train,y_train)
indices = [i for i in range(132)]
symptoms = df.columns.values[:-1]
dictionary = dict(zip(symptoms,indices))
def dosomething(symptom):
    user_input_symptoms = symptom
    user_input_label = [0 for i in range(132)]
    for i in user_input_symptoms:
        idx = dictionary[i]
        user_input_label[idx] = 1
    user_input_label = np.array(user_input_label)
    user_input_label = user_input_label.reshape((-1,1)).transpose()
    return(dt.predict(user_input_label))
@app.route('/')
def home():
    return "hello"

@app.route('/predict',methods=['POST'])
def predict():
    s1 = request.form.get('s1')
    s2 = request.form.get('s2')
    s3 = request.form.get('s3')
    s4 = request.form.get('s4')
    s5 = request.form.get('s5')

    x = dosomething([s1,s2,s3,s4,s5])
    r=x[0]

    return jsonify(r)
if __name__ == '__main__':
    app.run(debug=True)
