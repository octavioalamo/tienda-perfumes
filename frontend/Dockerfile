FROM node:13.12.0-alpine
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH

COPY . ./

RUN npm install
RUN npm run build

EXPOSE 3000

CMD ["npx", "serve", "-s", "build"]
