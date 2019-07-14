clear; close all; clc;

input_layer_size = 20;
output_layer_size = 10;
layer_sizes = [input_layer_size, 15, output_layer_size];


%get training data
m = 1000;
n = 20;

X_raw = ceil(rand(m, 2) * 10);
y_raw = max(X_raw, [], 2);

X = zeros(m, n);
y = zeros(m, 10);
for i = 1:m
  X(i, X_raw(i, 1)) = 1;
  X(i, 10 + X_raw(i, 2)) = 1;
  y(i, y_raw(i)) = 1;
endfor

%network

Theta = network([15], X, y)