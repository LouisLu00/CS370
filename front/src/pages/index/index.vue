<script setup>
import { useRoute, useRouter } from 'vue-router';
import { ref, onMounted } from 'vue';

const route = useRoute();
const router = useRouter();

const email = ref('');
const password = ref('');
const items = ref([]);

onMounted(async () => {
  email.value = route.query.email || '';
  password.value = route.query.password || '';
  await fetchData();
});

const fetchData = async () => {
  try {
    const response = await fetch('http://localhost:5050/fridge/list');
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    const data = await response.json();
    items.value = data;
  } catch (error) {
    console.error('Error fetching data:', error);
  }
};

const getExpirationDays = (expirationDate) => {
  const now = new Date();
  const expiration = new Date(expirationDate);
  const diffTime = expiration.getTime() - now.getTime();
  const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
  return diffDays;
};

const getImageSource = (item) => {
  if (item.ingredient) {
    return item.ingredient.img;
  } else {
    return item.otherImg;
  }
};

const getImageAlt = (item) => {
  if (item.ingredient) {
    return item.ingredient.name;
  } else {
    return item.otherName;
  }
};

const getItemName = (item) => {
  if (item.ingredient) {
    return item.ingredient.name;
  } else {
    return item.otherName;
  }
};

const getItemSubCategory = (item) => {
  if (item.ingredient && item.ingredient.subCategory) {
    return item.ingredient.subCategory;
  } else {
    return 'Other';
  }
};

const navigateToManualPage = () => {
  router.push({
    path: '/edit_ingredient'
  });
};

const navigateToCreator = () => {
  router.push({
    path: '/creator_recipe'
  });
};

const navigateToCameraPage = () => {
  alert("In program development...");
};
</script>

<template>
  <div class="flex-col page">
    <span class="self-start text">{{ email }}'s refrigerator</span>
    <div class="flex-row self-stretch group">
      <div class="flex-col justify-start items-center text-wrapper"><span class="font text_2">Fridge</span></div>
      <div class="flex-col justify-start text-wrapper_2 ml-11"><span class="font text_3">Recommendation</span></div>
      <div class="flex-col justify-start text-wrapper_2 ml-11" @click="navigateToCreator"><span class="font text_3">Creator</span></div>
    </div>
    <div class="grid">
      <div v-for="(item, index) in items" :key="index" class="flex-col grid-item">
        <div class="self-stretch section">
          <img class="image" :src="getImageSource(item)" :alt="getImageAlt(item)">
        </div>
        <div class="mt-10 flex-row justify-between items-baseline self-stretch">
          <span class="font">{{ getItemName(item) }}</span>
          <span class="font_2">{{ getItemSubCategory(item) }}</span>
        </div>
        <span class="mt-10 self-start font_3">Expires in {{ getExpirationDays(item.expirationDate) }} days</span>
      </div>
    </div>
    <div class="flex-col justify-start items-center self-center section_2">
      <div class="flex-col justify-start items-center button" @click="navigateToManualPage"><span class="font_4">Manual</span></div>
      <div class="flex-col justify-start items-center button" @click="navigateToCameraPage"><span class="font_4">Camera</span></div>
      <!-- <div class="flex-col justify-start items-center text-wrapper_3"><span class="text_4">+</span>
      </div> -->
    </div>
  </div>
</template>

<style scoped lang="css">
.ml-11 {
  margin-left: 0.69rem;
}

.page {
  padding: 4.13rem 1.13rem 5.5rem 1.13rem;
  width: 100%;
  overflow-y: auto;
  overflow-x: hidden;
  height: 100%;
}

.text {
  color: rgb(0, 0, 0);
  font-size: 1.31rem;
  font-family: 'Heiti SC';
  font-weight: 700;
  line-height: 1.31rem;
}

.group {
  margin-top: 2.25rem;
}

.text-wrapper {
  padding: 0.44rem 0 0.44rem;
  background-color: rgb(0, 0, 0);
  border-radius: 0.38rem;
  width: 2.81rem;
  height: 1.56rem;
}

.font {
  font-size: 0.69rem;
  font-family: 'Heiti SC';
  line-height: 0.69rem;
  font-weight: 700;
  color: rgb(0, 0, 0);
}

.text_2 {
  color: rgb(255, 255, 255);
}

.text-wrapper_2 {
  padding: 0.44rem 0 0.44rem;
  background-color: rgb(255, 255, 255);
  border-radius: 0.38rem;
  height: 1.56rem;
}

.text_3 {
  margin-left: 0.25rem;
  margin-right: 0.31rem;
}

.grid {
  margin-top: 1.81rem;
  height: 31.25rem;
  display: grid;
  grid-template-rows: repeat(3, minmax(0, 1fr));
  grid-template-columns: repeat(2, minmax(0, 1fr));
  row-gap: 0.69rem;
  column-gap: 1.31rem;
}

.grid-item {
  padding: 0.69rem 0.69rem 0.69rem 0.75rem;
  background-color: rgb(255, 255, 255);
  border-radius: 0.38rem;
}

.section {
  background-color: rgb(216, 216, 216);
  height: 5.94rem;
  border-left: solid 0.063rem rgb(151, 151, 151);
  border-right: solid 0.063rem rgb(151, 151, 151);
  border-top: solid 0.063rem rgb(151, 151, 151);
  border-bottom: solid 0.063rem rgb(151, 151, 151);
}

.font_2 {
  font-size: 0.56rem;
  font-family: 'Heiti SC';
  line-height: 0.56rem;
  font-weight: 700;
  color: rgb(85, 185, 126);
}

.font_3 {
  font-size: 0.69rem;
  font-family: 'Heiti SC';
  line-height: 0.69rem;
  font-weight: 700;
  color: rgb(151, 151, 151);
}

.section_2 {
  margin-top: 1.88rem;
  padding: 0.51rem 0 0.55rem;
  background-color: rgb(0, 0, 0);
  border-radius: 1.19rem;
  width: 5.5rem;
}

.text-wrapper_3 {
  overflow: hidden;
  width: 1.44rem;
  height: 2rem;
}

.text_4 {
  color: rgb(255, 255, 255);
  font-size: 2.44rem;
  font-family: 'Heiti SC';
  font-weight: 700;
  line-height: 2.44rem;
}

.image {
  width: 100%;
  height: 100%;
}

.font_4 {
    font-size: 0.88rem;
    font-family: 'Heiti SC';
    line-height: 0.88rem;
    font-weight: 700;
    color: rgb(255, 255, 255);
  }

  .button {
    padding: 0.56rem 0 0.63rem;
    background-color: rgb(0, 0, 0);
    border-radius: 0.56rem;
    width: 4.63rem;
  }
</style>